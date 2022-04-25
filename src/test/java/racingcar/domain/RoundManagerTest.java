package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundManagerTest {

    @DisplayName("현재 라운드와 총 라운드가 같지 않으면 라운드가 아직 끝나지 않았다.")
    @Test
    public void notEnd() {
        // given
        RoundManager roundManager = new RoundManager(3);
        // when
        boolean ended = roundManager.isNotEnded();
        // then
        assertThat(ended).isTrue();
    }

    @DisplayName("현재 라운드와 총 라운드가 같으면 모든 라운드 종료")
    @Test
    public void end() {
        // given
        RoundManager roundManager = new RoundManager(1);
        // when
        roundManager.nextRound();
        boolean ended = roundManager.isNotEnded();
        // then
        assertThat(ended).isFalse();
    }
}