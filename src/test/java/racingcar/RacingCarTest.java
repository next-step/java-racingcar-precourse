package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCarTest {

    @DisplayName("RacingCar 이름 생성")
    @ValueSource(strings = {"홍길동", "우승자", "장동건", "원빈", "생성자"})
    @ParameterizedTest
    void createTest(String name) {
        RacingCar car = new RacingCar(name);
    }

    @DisplayName("다섯글자 이상 RacingCar 이름 생성")
    @Test
    void createLengthErrorTest() {
        String name = "다섯자이상이다아";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCar(name))
                .withMessageContaining(PrintMessage.NAME_OUT_OF_LENGTH_ERROR.getMessage());
    }

    @DisplayName("비어있는 RacingCar 이름 생성")
    @Test
    void createEmptyErrorTest() {
        String name = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCar(name))
                .withMessageContaining(PrintMessage.NAME_EMPTY_ERROR.getMessage());
    }

    @DisplayName("RacingCar 전진 기능 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void move(int value) {
        String name = "원빈";
        RacingCar car = new RacingCar(name);
        car.move(value);
        assertThat(car.getMileage()).isEqualTo(1);
    }

    @DisplayName("RacingCar 전진 기능 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void notMove(int value) {
        String name = "원빈";
        RacingCar car = new RacingCar(name);
        car.move(value);
        assertThat(car.getMileage()).isEqualTo(0);
    }

    @DisplayName("RacingCar mileage 같을 시 equals 테스트")
    @Test
    void equals() {
        String name1 = "원빈";
        RacingCar car1 = new RacingCar(name1);
        car1.move(7);

        String name2 = "장동건";
        RacingCar car2 = new RacingCar(name2);
        car2.move(8);

        assertThat(car1.equals(car2)).isTrue();
    }
}
