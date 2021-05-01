import static org.assertj.core.api.Assertions.*;

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
}
