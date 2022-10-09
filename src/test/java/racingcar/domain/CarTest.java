package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 관련 기능")
class CarTest {
    private static final String NAME = "car1";

    @DisplayName("자동차를 생성한다.")
    @Test
    void create() {
        // when
        Car car = Car.from(NAME);

        // then
        assertThat(car).hasToString(String.format(Car.RACER_EXPRESSION, NAME, ""));
    }

    @DisplayName("경주해서 전진한다.")
    @Test
    void forward() {
        // given
        Car car = Car.from(NAME);
        Movement movement = () -> true;

        // when
        String carExpression = car.race(movement);

        // then
        assertThat(carExpression).hasToString(String.format(Car.RACER_EXPRESSION, NAME, "-"));
    }

    @DisplayName("경주해서 멈춘다.")
    @Test
    void stop() {
        // given
        Car car = Car.from(NAME);
        Movement movement = () -> false;

        // when
        String carExpression = car.race(movement);

        // then
        assertThat(carExpression).hasToString(String.format(Car.RACER_EXPRESSION, NAME, ""));
    }

    @DisplayName("위치가 일치하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"0, true", "1, false"})
    void forward(int comparePosition, boolean expected) {
        // given
        Car car = Car.from(NAME);

        // when
        boolean match = car.isWinner(comparePosition);

        // then
        assertThat(match).isEqualTo(expected);
    }
}
