package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationCarTest {
    @Test
    @DisplayName("길이_5이하의_이름_검증")
    void 길이5_이하의_이름_검증() {
        Assertions.assertDoesNotThrow(() -> new Car("아반데"));
    }

    @Test
    @DisplayName("길이_6이상의_이름_검증")
    void 길이5_초과의_이름_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car("아반데소나타"));
    }

    @Test
    @DisplayName("빈값_이름_검증")
    void 빈값_이름_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("null_이름_검증")
    void null_이름_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car(null));
    }
}
