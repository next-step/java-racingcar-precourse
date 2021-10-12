package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    public void 우상자_이름을_가진다() {
        String winnerName = "정기";
        Winner winner = new Winner(winnerName);
        Assertions.assertThat(winner.getName()).isEqualTo(winnerName);
    }
}
