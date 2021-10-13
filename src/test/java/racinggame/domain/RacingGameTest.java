package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("가장 많이 이동한 차가 승리한다.")
    void 우승자_판별() {
        CarNames carNames = new CarNames("자동차1,자동차2,자동차3");
        RaceNum raceNum = new RaceNum("3");
        RacingGame racingGame = new RacingGame(carNames, raceNum);

        Winners winners = racingGame.getWinners();
        MaxGoCount maxGoCount = racingGame.getMaxGoCount();

        for (Car winner : winners.getWinners()) {
            assertThat(winner.getGoCount().equals(maxGoCount.getMaxGoCount())).isTrue();
        }
    }
}
