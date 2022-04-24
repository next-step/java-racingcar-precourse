package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.CarMessage;

class CarTest {
    private final String carName = "mond";
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.create(Name.valueOf(carName));
    }

    @Test
    @DisplayName("자동차의 이름은 입력받은 값이다")
    void inputNameIsCarName() {
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest(name = "4이상 9이하의 수({0})이면 전진할 수 있다")
    @ValueSource(ints = {4, 9})
    void canMove(int number) {
        assertThat(car.isMoving(number)).isTrue();
    }

    @ParameterizedTest(name = "0이상 3이하의 수({0})이면 전진할 수 없다")
    @ValueSource(ints = {0, 3})
    void canNotMove(int number) {
        assertThat(car.isMoving(number)).isFalse();
    }

    @ParameterizedTest(name = "0보다 작거나 9보다 큰 수({0})는 잘못된 값이다")
    @ValueSource(ints = {-1, 10})
    void invalidNumber(int number) {
        assertThatThrownBy(() -> car.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarMessage.INVALID_NUMBER_RANGE);
    }

    @ParameterizedTest(name = "전진 가능한 값({0})이면 움직인다")
    @ValueSource(ints = {4, 9})
    void isMovingTrueThenMoveCar(int number) {
        car.move(number);
        Position position = car.getPosition();
        assertThat(position.getValue()).isEqualTo(1);
    }

    @ParameterizedTest(name = "전진 가능한 값({0})이 아니면 움직이지 않는다")
    @ValueSource(ints = {0, 3})
    void isMovingFalseThenDontMoveCar(int number) {
        car.move(number);
        Position position = car.getPosition();
        assertThat(position.getValue()).isZero();
    }
}
