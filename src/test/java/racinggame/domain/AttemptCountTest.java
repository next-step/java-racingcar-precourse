package racinggame.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class AttemptCountTest {

    @Test
    @DisplayName("시도 횟수를 입력할 수 있다.")
    void create() {
        AttemptCount attemptCount = new AttemptCount("5");

        assertThat(attemptCount.getAttemptCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12g", "^qa1"})
    @DisplayName("숫자만 입력할 수 있다.")
    void only_number(String input) {
        ThrowableAssert.ThrowingCallable onlyNumber = () -> new AttemptCount(input);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(onlyNumber);
    }

    @Test
    @DisplayName("시도 횟수는 0이 올 수 없다.")
    void not_zero() {
        ThrowableAssert.ThrowingCallable notZero = () -> new AttemptCount("0");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(notZero);
    }
}