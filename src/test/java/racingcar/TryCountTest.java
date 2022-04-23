package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TryCountTest {
    @Test
    void init() {
        TryCount tryCount = new TryCount("5");

        assertThat(tryCount.getValue()).isEqualTo(5);
    }

    @Test
    void validateTryCount() {
        assertThrows(IllegalArgumentException.class, () -> new TryCount("5s"));
    }
}
