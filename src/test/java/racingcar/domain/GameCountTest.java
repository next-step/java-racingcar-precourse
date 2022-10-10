package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.GameCount.*;

import org.junit.jupiter.api.Test;

class GameCountTest {
    @Test
    void 카운트_입력값_검증() {
        assertDoesNotThrow(() -> new GameCount("33"));
        assertThatThrownBy(() -> new GameCount("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_COUNT);
        assertThatThrownBy(() -> new GameCount(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_COUNT);
        assertThatThrownBy(() -> new GameCount("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_COUNT);
    }

    @Test
    void isContinueTest() {
        GameCount gameCount = new GameCount("2");
        assertThat(gameCount.isContinue()).isTrue();
        gameCount.playCount();
        assertThat(gameCount.isContinue()).isTrue();
        gameCount.playCount();
        assertThat(gameCount.isContinue()).isFalse();
    }
}