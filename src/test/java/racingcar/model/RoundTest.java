package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundTest {

    @DisplayName("숫자가 아닌 문자가 들어갔을 경우 에러 테스트")
    @Test
    void throwsExceptionWhenNotNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Round("N"))
                .withMessage(Round.NOT_NUMBER_ERROR_MSG);
    }

    @DisplayName("최소값 미만의 값을 시도 경우 에러 테스트")
    @Test
    void throwsExceptionWhenZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Round("0"))
                .withMessage(Round.MIN_ROUND_NUMER_ERROR_MSG);
    }

}
