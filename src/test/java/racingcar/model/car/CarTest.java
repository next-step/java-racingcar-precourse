package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.racing.random.RandomRacingConfig;
import racingcar.model.racing.random.RandomRacingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        int racingCount = 5;
        Car car = new Car();

        // when
        car.race(racingStrategy, racingCount);

        // then
        assertThat(car.getPosition())
                .isNotNegative()
                .isLessThanOrEqualTo(racingCount);
    }

    @Test
    @DisplayName("경주 횟수가 0 이하면 예외가 발생한다.")
    void raceZero() {
        // given
        int racingCount = 0;
        Car car = new Car();

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> car.race(racingStrategy, racingCount));

        // then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.CAR_RACING_COUNT_GREATER_THAN_ZERO);
    }
}
