package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.domain.errors.CarErrors;

class CarPositionTest {

    @ParameterizedTest(name = "정상적으로 위치 객체를 생성한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void create_car_position(int validPosition) {
        // given: none

        // when, then
        assertThatCode(() -> new CarPosition(validPosition))
                .doesNotThrowAnyException();
    }

    @DisplayName("위치 객체를 생성한다. 0 미만의 위치는 가질 수 없다.")
    @Test
    void create_car_position_less_than_0() {
        // given
        int invalidPosition = -1;

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> new CarPosition(invalidPosition))
                .withMessageStartingWith(CarErrors.CAR_POSITION_LESS_THAN_ZERO_ERROR);
    }

    @DisplayName("두 위치객체 중, 더 큰 위치객체를 찾는다.")
    @Test
    void get_greater_car_position_from_two_position() {
        // given
        int lessPosition = 1;
        int greaterPosition = 2;

        CarPosition position1 = new CarPosition(lessPosition);
        CarPosition position2 = new CarPosition(greaterPosition);

        // when, then
        assertThat(position1.getGreaterCarPosition(position2))
                .isEqualTo(new CarPosition(greaterPosition));
    }

    @DisplayName("두 위치객체를 비교하려면, 항상 비교대상이 존재해야한다.")
    @Test
    void get_greater_car_position_from_two_position_invalid() {
        // given
        CarPosition position = new CarPosition(1);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> position.getGreaterCarPosition(null))
                .withMessage(CarErrors.CAR_POSITION_EMPTY_ERROR);
    }
}
