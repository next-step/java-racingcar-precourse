import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        Game game = new Game(3);
        cars = Arrays.asList(
            new Car("페라리"), new Car("람보르기니"), new Car("롤스로이스"));

        // index 0 car는 3번 전진
        for (int i = 0; i < Game.getGoal(); i++) {
            cars.get(0).setCarStatus(CarStatus.MOVE);
            cars.get(2).setCarStatus(CarStatus.MOVE);
        }

        // index 1 car는 1번 전진
        cars.get(1).setCarStatus(CarStatus.MOVE);
    }

    @Test
    @DisplayName("자동차_상태_변경_테스트")
    void carStatusChangeTest() {
        assertThat(Utils.getCarStatus(1)).isEqualTo(CarStatus.STOP);
        assertThat(Utils.getCarStatus(2)).isEqualTo(CarStatus.STOP);
        assertThat(Utils.getCarStatus(3)).isEqualTo(CarStatus.STOP);
        assertThat(Utils.getCarStatus(4)).isEqualTo(CarStatus.MOVE);
        assertThat(Utils.getCarStatus(5)).isEqualTo(CarStatus.MOVE);
        assertThat(Utils.getCarStatus(6)).isEqualTo(CarStatus.MOVE);
        assertThat(Utils.getCarStatus(7)).isEqualTo(CarStatus.MOVE);
        assertThat(Utils.getCarStatus(8)).isEqualTo(CarStatus.MOVE);
        assertThat(Utils.getCarStatus(9)).isEqualTo(CarStatus.MOVE);
    }

    @Test
    @DisplayName("자동차_골_여부_확인")
    void carStatusEqualsGoalCheckTest() {
        assertThat(Utils.carStatusEqualsGoalCheck(cars.get(0))).isTrue();
        assertThat(Utils.carStatusEqualsGoalCheck(cars.get(1))).isFalse();
        assertThat(Utils.carStatusEqualsGoalCheck(cars.get(2))).isTrue();
    }

    @Test
    @DisplayName("자동차_상태가_골인_리스트_가져오기")
    void getCarStatusEqualsGoalTest() {
        assertThat(Utils.getCarStatusEqualsGoal(cars)).hasSize(2).contains(cars.get(0)).contains(cars.get(2));
    }

    @Test
    @DisplayName("car_name_5자리_검증_테스트_성공")
    void CarNameValidTestSuccess() {
        assertThat(Utils.carNameValid("람보르기니")).isTrue();
    }

    @Test
    @DisplayName("car_name_5자리_검증_테스트_실패")
    void CarNameValidTestFail() {
        assertThatThrownBy(() -> Utils.carNameValid("메르세데스벤츠")).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름이 5자리 이상입니다.");
    }

    @Test
    @DisplayName("입력_된_자동차_개수_검증_성공")
    void inputCarSizeValidTestSuccess() {
        List<String> names = new ArrayList<>(Arrays.asList("페라리", "람보르기니"));
        assertThat(Utils.inputCarSizeValid(names)).isTrue();
    }

    @Test
    @DisplayName("입력_된_자동차_개수_검증_실패")
    void inputCarSizeValidTestFail() {
        List<String> names = new ArrayList<>();
        assertThatThrownBy(() -> Utils.inputCarSizeValid(names)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1개 이상의 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("중복된_이름이_있는지_검증_성공")
    void inputCarNameDuplicateValidTestSuccess() {
        List<String> names = new ArrayList<>(Arrays.asList("페라리", "벤츠"));
        assertThat(Utils.inputCarNameDuplicateValid(names)).isTrue();
    }

    @Test
    @DisplayName("중복된_이름이_있는지_검증_실패")
    void inputCarNameDuplicateValidTestFail() {
        List<String> names = new ArrayList<>(Arrays.asList("페라리", "페라리"));
        assertThatThrownBy(() -> Utils.inputCarNameDuplicateValid(names)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 이름이 존재합니다.");
    }
}
