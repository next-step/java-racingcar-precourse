package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberOfAttemptsTest {

    @Test
    void 시도횟수_음수() {
        assertThatThrownBy(
                () -> new NumberOfAttempts(-3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0() {
        assertThatThrownBy(
                () -> new NumberOfAttempts(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
