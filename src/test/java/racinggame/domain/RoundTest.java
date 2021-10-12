package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    public void 총라운드_정보를_가진다() {
        Round round = new Round(5);
        Assertions.assertThat(round.getRoundCount()).isEqualTo(5);
    }

    @Test
    public void 현재_라운드_정보를_가진다() {
        Round round = new Round(5);
        Assertions.assertThat(round.getCurrentRound()).isEqualTo(0);
    }

    @Test
    public void 라운드를_진행시킬_수_있다() {
        Round round = new Round(5);
        round.next();
        Assertions.assertThat(round.getCurrentRound()).isEqualTo(1);
    }
}
