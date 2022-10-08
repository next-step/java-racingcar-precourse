package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a"})
    void 시도할_횟수는_숫자형식의_문자열_이어야_한다(String tryCount) {
        assertThatCode(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 회수는 숫자형식 이어야 합니다.");
    }

    @Test
    void 시도할_횟수는_양수_이어야_한다() {
        assertThatCode(() -> new TryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 회수는 양수여야 합니다.");
    }
}