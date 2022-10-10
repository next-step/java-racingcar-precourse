package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

public class RoundTest {
    @DisplayName("숫자가 아닌 입력이 들어온 경우 예외")
    @Test
    void 숫자가_아닌_입력이_들어온_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round("N"))
            .withMessage(IllegalArgumentException.MSG_NOT_NUMBER);
    }

    @DisplayName("시도회수 숫자가 1미만인 경우 예외")
    @Test
    void 시도회수_숫자가_1미만인_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round("0"))
            .withMessage(IllegalArgumentException.MSG_MIN_ROUND_NUMBER);
    }

}
