package racingcar.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AttemptCountTest {

    @Test
    void 시도_횟수_생성_검증() {
        AttemptCount attemptCount = new AttemptCount("5");

        assertThat(attemptCount.getAttemptCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12g", "^qa1"})
    void 숫자만_입력_검증(String input) {
        ThrowableAssert.ThrowingCallable onlyNumber = () -> new AttemptCount(input);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(onlyNumber);
    }

    @Test
    void 시도_횟수_0_Exception_검증() {
        ThrowableAssert.ThrowingCallable notZero = () -> new AttemptCount("0");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(notZero);
    }
}