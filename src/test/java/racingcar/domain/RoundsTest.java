package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundsTest {

    @DisplayName("라운드 넘버로 해당 라운드를 가져온다.")
    @Test
    public void getRound() {
        // given
        Rounds rounds = new Rounds(2);
        RoundNumber roundNumber = new RoundNumber(1);
        // when
        Round find = rounds.getRound(roundNumber);
        // then
        assertThat(find).isNotNull();
    }

}