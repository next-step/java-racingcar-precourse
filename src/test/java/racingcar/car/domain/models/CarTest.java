package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.car.domain.errors.CarErrors;
import racingcar.car.domain.external.CarMovePolicyStrategy;

class CarTest {

    private static final String carName = "sjlee";

    @DisplayName("정상적으로 자동차 객체를 생성한다.")
    @Test
    void create_car() {
        // given: none

        // when, then
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "자동차 한대를 앞으로 전진한다.")
    @MethodSource("move_car_parameter")
    void move_car(Car beforeMoved, CarMovePolicyStrategy policy, Car afterMoved) {
        // given: none

        // when, then
        assertThat(beforeMoved.moveForward(policy)).isEqualTo(afterMoved);
    }

    static Stream<Arguments> move_car_parameter() {
        return Stream.of(
                Arguments.of(new Car(carName, 0), (CarMovePolicyStrategy) () -> CarMovePolicy.MOVE, new Car(carName, 1)),
                Arguments.of(new Car(carName, 1), (CarMovePolicyStrategy) () -> CarMovePolicy.MOVE, new Car(carName, 2)),
                Arguments.of(new Car(carName, 2), (CarMovePolicyStrategy) () -> CarMovePolicy.STOP, new Car(carName, 2)),
                Arguments.of(new Car(carName, 3), (CarMovePolicyStrategy) () -> CarMovePolicy.STOP, new Car(carName, 3)));
    }

    @ParameterizedTest(name = "자동차의 이름과 위치를 반환한다.")
    @MethodSource("car_to_string_parameter")
    void car_to_string(Car car, String expected) {
        // given: none

        // when, then
        assertThat(car.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> car_to_string_parameter() {
        return Stream.of(
                Arguments.of(new Car("test0", 0), "test0 : "),
                Arguments.of(new Car("test1", 1), "test1 : -"),
                Arguments.of(new Car("test5", 5), "test5 : -----"));
    }

    @DisplayName("자동차들을 움직일 때, 올바르지 않은 전략이 파라미터로 들어오는 경우 처리")
    @Test
    void move_cars_invalid_parameter() {
        // given: none

        // when
        assertThatIllegalStateException()
                .isThrownBy(() -> new Car(carName).moveForward(null))
                .withMessage(CarErrors.CAR_MOVE_STRATEGY_ERROR);
    }

    @DisplayName("두 자동차 중, 더 큰 위치값을 갖는 자동차의 위치값을 반환한다.")
    @Test
    void get_greater_car_position_car_between_two_cars() {
        // given
        int lessPosition = 9;
        int greaterPosition = 10;

        Car car = new Car(carName, lessPosition);
        CarPosition anotherCarPosition = new CarPosition(greaterPosition);

        // when
        CarPosition position = car.getGreaterCarPosition(anotherCarPosition);

        // then
        assertThat(position).isEqualTo(new CarPosition(greaterPosition));
    }

    @DisplayName("두 자동차의 위치정보를 비교하려면, 항상 비교대상이 존재해야한다.")
    @Test
    void get_greater_car_position_car_between_two_cars_invalid() {
        // given
        Car car = new Car(carName);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> car.getGreaterCarPosition(null))
                .withMessage(CarErrors.CAR_POSITION_EMPTY_ERROR);
    }

    @ParameterizedTest(name = "자동차가 같은 위치값을 갖는지 비교한다.")
    @MethodSource("compare_car_has_same_position_parameter")
    void compare_car_has_same_position(Car car, CarPosition position, boolean expected) {
        // given: none

        // when, then
        assertThat(car.hasSamePosition(position)).isEqualTo(expected);
    }

    static Stream<Arguments> compare_car_has_same_position_parameter() {
        return Stream.of(
                Arguments.of(new Car(carName, 1), new CarPosition(1), true),
                Arguments.of(new Car(carName, 1), new CarPosition(2), false));
    }

    @DisplayName("자동차의 위치값이 동등하지 비교하기 위해서, 항상 비교대상이 존재해야한다")
    @Test
    void compare_car_has_same_position_invalid() {
        // given
        Car car = new Car(carName);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> car.hasSamePosition(null))
                .withMessage(CarErrors.CAR_POSITION_EMPTY_ERROR);
    }


}
