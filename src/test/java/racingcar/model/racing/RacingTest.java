package racingcar.model.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.racing.random.RandomRacingConfig;
import racingcar.model.racing.random.RandomRacingStrategy;
import racingcar.model.record.RacingRecord;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @Test
    @DisplayName("최종 우승자는 1명 이상이다.")
    void championCountIsPositive() {
        // given
        RacingStrategy racingStrategy = new RandomRacingStrategy(RandomRacingConfig.START_RANDOM_NUMBER,
                                                                 RandomRacingConfig.END_RANDOM_NUMBER,
                                                                 RandomRacingConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);

        Racing racing = Racing.builder()
                .carNames("car1,car2,car3")
                .lapCount("5")
                .build();

        // when
        RacingRecord racingRecord = racing.start(racingStrategy);

        // then
        assertThat(racingRecord.getLapCount()).isEqualTo(5);
        assertThat(racingRecord.getChampionNames()).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("모든 자동차의 위치가 동일한 경우 최종 우승자의 수는 모든 자동차의 수와 같다.")
    void championCountIsEqualToCarCount() {
        // given
        RacingStrategy racingStrategy = () -> RacingStatus.GO;

        Racing racing = Racing.builder()
                .carNames("car1,car2,car3")
                .lapCount("5")
                .build();

        // when
        RacingRecord racingRecord = racing.start(racingStrategy);

        // then
        assertThat(racingRecord.getLapCount()).isEqualTo(5);
        assertThat(racingRecord.getChampionNames()).hasSize(3);
    }
}
