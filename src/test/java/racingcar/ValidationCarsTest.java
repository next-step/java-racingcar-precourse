package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationCarsTest {
    @Test
    @DisplayName("길이_5이하의_이름들_검증")
    void 길이5_이하의_이름들_검증() {
        Assertions.assertDoesNotThrow(() -> new Cars("pobi,woni"));
    }

    @Test
    @DisplayName("길이5_초가된_이름이_포함된_검증")
    void 길이5_초가된_이름이_포함된_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Cars("pobi,woni,pobiwoni"));
    }

    @Test
    @DisplayName("빈값_이름이_포함된_검증")
    void 빈값_이름이_포함된_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Cars(""));
    }
}
