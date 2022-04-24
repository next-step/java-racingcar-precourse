package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRoundTest {

    @DisplayName("입력 횟수를 0보다 큰 수를 입력했을때, 라운드가 안 끝났는지")
    @Test
    void gameRoundTest() {
        // given
        int round = 3;

        // when
        GameRound gameRound = new GameRound(round);

        // then
        assertThat(gameRound.isEnd()).isFalse();
    }

    @DisplayName("입력 횟수를 0을 입력했을때, 라운드가 끝났는지 확인하는지 테스트")
    @Test
    void gameRoundFail() {
        // given
        int round = 0;

        // when
        GameRound gameRound = new GameRound(round);

        // then
        assertThat(gameRound.isEnd()).isTrue();
    }

}
