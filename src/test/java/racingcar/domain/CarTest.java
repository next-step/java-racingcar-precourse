package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"test123", "nextstep", "carracing"})
    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException이 발생한다.")
    void check_validate_carname_test(String carName) {
        assertThatThrownBy(() ->
            new Car(carName)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("4이상이동거리가 인 경우 이동한다.")
    void car_move_test() {
        //given
        Car car = new Car("test");

        //when
        car.moveForward(() -> true);
        int getMoveDistance = car.getMoveDistance();

        //then
        assertThat(getMoveDistance).isEqualTo(1);
    }

    @Test
    @DisplayName("3 이하인 경우 이동하지 않는다.")
    void car_no_move_test() {
        //given
        Car car = new Car("test");

        //when
        car.moveForward(() -> false);
        int getMoveDistance = car.getMoveDistance();

        //then
        assertThat(getMoveDistance).isEqualTo(0);
    }
}