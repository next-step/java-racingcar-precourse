package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {

    @Test
    @DisplayName("시도 횟수, 0이하면 에러")
    void validateNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Count("0"));
    }
}
