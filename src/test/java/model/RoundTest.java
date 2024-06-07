package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -10})
    void 시도횟수가_1_미만이면_예외발생(int round) {
        //when, then
        assertThatThrownBy(() -> new Round(round))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 시도 횟수는 최소 1 이상이어야 합니다.");
    }

    @Test
    void 매시도마다_1씩_감소하고_횟수가_0이되면_False_반환() {
        // given
        Round round = new Round(3);

        // when
        round.finishOneRound();
        round.finishOneRound();
        round.finishOneRound();

        // then
        assertThat(round.isInProgress()).isFalse();
    }
}
