package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.racing.random.RandomRacingConfig;
import racingcar.model.racing.random.RandomRacingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private RacingStrategy racingStrategy;

    @BeforeEach
    void setUp() {
        racingStrategy = new RandomRacingStrategy(RandomRacingConfig.START_RANDOM_NUMBER,
                                                  RandomRacingConfig.END_RANDOM_NUMBER,
                                                  RandomRacingConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("n회 경주시 자동차의 위치는 0에서 n 사이의 값이다.")
    void raceFiveTimes() {
        // given
        Car car = new Car("car1");
        LapCount lapCount = new LapCount("5");

        // when
        car.race(racingStrategy, lapCount);

        // then
        assertThat(car.getPosition())
                .isNotNegative()
                .isLessThanOrEqualTo(lapCount.getLapCount());
    }
}
