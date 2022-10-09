package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayingCountTest {
    @Test
    @DisplayName("이동_횟수_빈값_입력_체크")
    void 이동_횟수_빈값_입력_체크() {
        assertThatThrownBy(
                () -> new PlayingCount("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PLAYING_COUNT_EMPTY);
    }

    @Test
    @DisplayName("이동_횟수_양수만_입력_가능")
    void 이동_횟수_양수만_입력_가능() {
        assertThatThrownBy(
                () -> new PlayingCount("-1")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PLAYING_COUNT_RANGE);
    }

    @Test
    @DisplayName("이동_횟수_최대값_채크")
    void 이동_횟수_최대값_채크() {
        assertThatThrownBy(
                () -> new PlayingCount("2147483648")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PLAYING_COUNT_MAX);
    }
}
