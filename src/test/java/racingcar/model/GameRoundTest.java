package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRoundTest {
    @Test
    @DisplayName("게임_라운드_숫자여야한다")
    void game_round_is_numeric_success() {
        GameRound gameRound = new GameRound("12345");
        Assertions.assertThat(gameRound.getRound()).isEqualTo(12345);
    }
    
    @Test
    @DisplayName("게임_라운드_0일_경우_에러")
    void game_round_zero_error() {
        Assertions.assertThatThrownBy(() -> new GameRound("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0이상으로 입력해주세요.");
    }

    @Test
    @DisplayName("게임_라운드_숫자_아닐경우_에러")
    void game_round_is_numeric_error() {
        Assertions.assertThatThrownBy(() -> new GameRound("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }
}