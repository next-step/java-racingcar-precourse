package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceProgressTest {

    @Test
    @DisplayName("숫자가 4이상이면 전진한다")
    void 숫자가_4이상이면_전진한다() {
        RaceProgress raceProgress = new RaceProgress();
        int currentRaceProgress = raceProgress.getProgress();
        raceProgress.forwardProgress(4);
        assertThat(raceProgress.getProgress()).isEqualTo(currentRaceProgress + 1);
    }

    @Test
    @DisplayName("숫자가 3이하이면 전진하지 않는다")
    void 숫자가_3이하이면_전진하지_않는다() {
        RaceProgress raceProgress = new RaceProgress();
        int currentRaceProgress = raceProgress.getProgress();
        raceProgress.forwardProgress(3);
        assertThat(raceProgress.getProgress()).isEqualTo(currentRaceProgress);
    }
}