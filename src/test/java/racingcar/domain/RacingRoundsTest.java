package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingRoundsTest {
    @Test
    void 횟수는_숫자만_입력가능하다() {
        assertThatThrownBy(() -> {
            RacingRounds rounds = new RacingRounds("ddd");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    @Test
    void 횟수가_0이되면_자동차_경주는_종료한다() {
        RacingRounds rounds = new RacingRounds("1");
        rounds.endCurrentRound();
        assertThat(rounds.isEndGame()).isTrue();
    }

    @Test
    void 횟수가_0이_아니면_경기는_종료하지_않는다() {
        RacingRounds rounds = new RacingRounds("2");
        assertThat(rounds.isEndGame()).isFalse();
    }
}
