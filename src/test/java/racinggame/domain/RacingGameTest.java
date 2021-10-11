package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    ArrayList<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("자동차1");
        carNames.add("자동차2");
        carNames.add("자동차3");
    }

    @Test
    @DisplayName("가장 많이 이동한 차가 승리한다.")
    void 우승자_판별() {
        RacingGame racingGame = new RacingGame(carNames, 3);

        ArrayList<Car> winners = racingGame.getWinners();
        int maxGoCount = racingGame.getMaxGoCount();

        for (Car winner : winners) {
            assertThat(winner.getGoCount()).isEqualTo(maxGoCount);
        }
    }
}
