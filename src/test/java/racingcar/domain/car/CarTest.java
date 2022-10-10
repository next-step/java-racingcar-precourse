package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.AlwaysForwardStrategy;
import racingcar.domain.Fixtures;

public class CarTest {
    private CarMovingStrategy strategy;

    @BeforeEach
    void setUp() {
        this.strategy = Fixtures.ALWAYS_FORWARD_ONE_STRATEGY;
    }

    @ParameterizedTest(name = "자동차 이름은 비어 있지 않아야 한다.")
    @NullSource
    void nameShouldNotNull(CarName name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name, strategy))
                .withMessage("The 'name' should not be null!");
    }

    @ParameterizedTest(name = "자동차 전진 전략은 비어 있지 않아야 한다.")
    @NullSource
    void strategyShouldNotNull(CarMovingStrategy strategy) {
        final CarName name = new CarName("Benz");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name, strategy))
                .withMessage("The 'strategy' should not be null!");
    }

    @ParameterizedTest(name = "자동차를 생성할 때 주었던 이름을 알 수 있다.")
    @ValueSource(strings = {"Benz", "BMW"})
    void name(String name) {
        final Car car = createCar(name);
        final CarName expected = new CarName(name);

        final CarName actual = car.getName();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차가 처음 생성되면 현재 위치는 0이다.")
    @Test
    void initialDistance() {
        final Car car = createCar("mini");
        final Distance expected = Distance.ZERO;

        final Distance actual = car.getDistanceFromStartingPoint();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "자동차는 전진전략대로 이동한다. 이동거리: {0}")
    @ValueSource(ints = {0, 1})
    void move(int givenDistance) {
        final Distance distanceAtOnce = new Distance(givenDistance);
        final CarMovingStrategy strategy = new AlwaysForwardStrategy(distanceAtOnce);
        final Car car = createCar("mini", strategy);
        final Distance expected = new Distance(givenDistance);

        car.move();
        final Distance actual = car.getDistanceFromStartingPoint();

        assertThat(actual).isEqualTo(expected);
    }

    private Car createCar(String name) {
        return createCar(name, strategy);
    }

    private Car createCar(String name, CarMovingStrategy strategy) {
        final CarName carName = new CarName(name);
        return new Car(carName, strategy);
    }
}
