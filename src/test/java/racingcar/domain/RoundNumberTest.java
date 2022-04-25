package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundNumberTest {

    @DisplayName("다음 라운드 번호를 가져온다.")
    @Test
    public void nextRound() {
        // given
        RoundNumber roundNumber = new RoundNumber(1);
        // when
        RoundNumber next = roundNumber.nextRound();
        // then
        assertThat(roundNumber).isNotEqualTo(next);
    }
}
