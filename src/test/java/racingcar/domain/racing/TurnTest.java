package racingcar.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnTest {

    private final String TURN_VALUE_REGEX = "^[1-9]+$";

    @Test
    @DisplayName("턴횟수_입력값_검증")
    void 턴횟수_입력값_검증() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turn(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Turn(-1);
        });
    }
}
