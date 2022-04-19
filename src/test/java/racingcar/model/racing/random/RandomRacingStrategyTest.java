package racingcar.model.racing.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.racing.RacingStatus;

import static org.assertj.core.api.Assertions.assertThat;

class RandomRacingStrategyTest {
    private RandomRacingStrategy randomRacingStrategy;

    @BeforeEach
    void setUp() {
        randomRacingStrategy = new RandomRacingStrategy(RandomRacingConfig.START_RANDOM_NUMBER,
                                                           RandomRacingConfig.END_RANDOM_NUMBER,
                                                           RandomRacingConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
    }

    @Test
    @DisplayName("0에서 9사이의 random 값 1개를 구한다.")
    void pickRandomNumber() {
        // given

        // when
        int randomNumber = randomRacingStrategy.pickRandomNumber();

        // then
        assertThat(randomNumber)
                .isNotNegative()
                .isLessThanOrEqualTo(9)
                .isLessThan(10);
    }

    @Test
    @DisplayName("값이 4 이상일 경우 전진한다.")
    void go() {
        // given
        int randomNumber = 4;

        // when
        RacingStatus racingStatus = randomRacingStrategy.race(randomNumber);

        // then
        assertThat(racingStatus).isEqualTo(RacingStatus.GO);
    }

    @Test
    @DisplayName("값이 3 이하일 경우 멈춘다.")
    void stop() {
        // given
        int randomNumber = 3;

        // when
        RacingStatus racingStatus = randomRacingStrategy.race(randomNumber);

        // then
        assertThat(racingStatus).isEqualTo(RacingStatus.STOP);
    }

    @Test
    @DisplayName("random 값을 구해서 전진하거나 멈춘다.")
    void stopAndGo() {
        // given

        // when
        RacingStatus racingStatus = randomRacingStrategy.race();

        // then
        assertThat(racingStatus).isNotNull();
    }
}
