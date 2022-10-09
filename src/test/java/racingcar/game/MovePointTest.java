package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MovePointTest {

    @Test
    @DisplayName("숫자로 변환할 수 없으면 IllegalArgumentException 발생")
    void validateMovePoint() {
        String testMovePoint = "1test";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            MovePoint movePoint = new MovePoint(testMovePoint);
        }).withMessage(
                "[ERROR] You cannot change the entered string to a numeric type. Check your input: " + testMovePoint
        );
    }
}
