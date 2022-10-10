package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.domain.Fixtures;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;

class CarStatusTest {
    private final CarName name = new CarName("car");
    private final Distance distanceFromStartingPoint = new Distance(3);

    @ParameterizedTest(name = "자동차 이름은 null이 아니어야 한다.")
    @NullSource
    void nameShouldNotBeNull(CarName nullName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarStatus(nullName, distanceFromStartingPoint))
                .withMessage("The car name should not be null!");
    }

    @ParameterizedTest(name = "자동차 현재 위치는 null이 아니어야 한다.")
    @NullSource
    void distanceShouldNotBeNull(Distance nullDistance) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarStatus(name, nullDistance))
                .withMessage("The distance from starting point should not be null!");
    }

    @DisplayName("현재 위치를 생성할 수 있다.")
    @Test
    void construct() {
        final CarStatus status = new CarStatus(name, distanceFromStartingPoint);
        final String expectedName = "car";
        final int expectedDistance = 3;

        assertAll(
                () -> assertThat(status.getName()).isEqualTo(expectedName),
                () -> assertThat(status.getDistanceFromStartingPoint()).isEqualTo(expectedDistance)
        );
    }

    @DisplayName("자동차 상태가 같으면 동일하다.")
    @Test
    void equality() {
        final CarStatus one = Fixtures.createCarStatus("equal", 1);
        final CarStatus another = Fixtures.createCarStatus("equal", 1);

        assertThat(one).isEqualTo(another);
    }

    @ParameterizedTest(name = "자동차는 null이 아니어야 한다.")
    @NullSource
    void carShouldNotBeNull(Car nullCar) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarStatus.from(nullCar))
                .withMessage("The car should not be null!");
    }

    @DisplayName("자동차로 상태를 생성할 수 있다.")
    @Test
    void createFromCar() {
        final CarName name = new CarName("name");
        final Car car = new Car(name, Fixtures.ALWAYS_FORWARD_ONE_STRATEGY);
        final CarStatus expected = Fixtures.createCarStatus("name", 0);

        final CarStatus actual = CarStatus.from(car);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "a 현재 위치 = {0}, b 현재 위치 = {1}, 비교 결과 = {2} (참고: '1': '>', '0': '=', '-1': '<')")
    @CsvSource({
            "1, 2, -1",
            "3, 3, 0",
            "4, 1, 1"
    })
    void compareTo(int aDistance, int bDistance, int expected) {
        final CarStatus a = Fixtures.createCarStatus("a", aDistance);
        final CarStatus b = Fixtures.createCarStatus("b", bDistance);

        final int actual = a.compareTo(b);

        assertThat(actual).isEqualTo(expected);
    }
}
