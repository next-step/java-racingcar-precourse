package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.movement.random.RandomMovementConfig;
import racingcar.model.movement.random.RandomMovementStrategy;
import racingcar.model.lap.LapCount;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("n회 경주시 자동차의 위치는 0에서 n 사이의 값이다.")
    void raceFiveTimes() {
        // given
        MovementStrategy movementStrategy = new RandomMovementStrategy(RandomMovementConfig.START_RANDOM_NUMBER,
                                                                       RandomMovementConfig.END_RANDOM_NUMBER,
                                                                       RandomMovementConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
        Car car = new Car("car1");
        LapCount lapCount = new LapCount("5");

        // when
        car.race(movementStrategy);

        // then
        assertThat(car.getPosition())
                .isNotNegative()
                .isLessThanOrEqualTo(lapCount.getCount());
    }
}
