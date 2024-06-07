package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 자동차_이름이_빈문자열이면_예외발생(String carName) {
        // when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차의 이름은 null 이거나 빈 문자열일 수 없습니다.");
    }

    @Test
    void 자동차_이름이_null이면_예외발생() {
        // given
        String carName = null;

        //when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차의 이름은 null 이거나 빈 문자열일 수 없습니다.");
    }

    @Test
    void 자동차_이름이_5글자를_초과하면_예외발생() {
        // given
        String carName = "CarCarCar";

        //when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차의 이름은 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car!!", "@@", "Car12"})
    void 자동차_이름이_영문이_아니면_예외발생(String carName) {
        //when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차의 이름은 영문으로만 이루어질 수 있습니다.");
    }

    @Test
    void 조건이_만족되면_이동() {
        // given
        Car car = new Car("test");
        CarMoveRule alwaysMoveRule = () -> true;

        // when
        CarState carState = car.moveOrStay(alwaysMoveRule);

        // then
        int expectedPosition = 1;
        assertThat(carState.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 조건이_만족되지_않으면_이동x() {
        // given
        Car car = new Car("test");
        CarMoveRule neverMoveRule = () -> false;

        // when
        CarState carState = car.moveOrStay(neverMoveRule);

        // then
        int expected = 0;
        assertThat(carState.getPosition()).isEqualTo(expected);
    }
}
