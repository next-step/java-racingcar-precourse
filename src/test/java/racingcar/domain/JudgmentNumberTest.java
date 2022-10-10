package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JudgmentNumberTest {
    @ParameterizedTest(name = "number: {arguments}")
    @ValueSource(ints = {JudgmentNumber.MIN_NUMBER - 1, JudgmentNumber.MAX_NUMBER + 1})
    @DisplayName("0 ~ 9 사이의 숫자가 아니면 예외가 발생한다.")
    void 특범위를_벗어난_숫자_생성(int number) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> JudgmentNumber.from(number))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(
                        ErrorMessage
                                .OUT_OF_RANGE_NUMBER_ERROR
                                .getMessage(JudgmentNumber.MIN_NUMBER, JudgmentNumber.MAX_NUMBER));
    }
}
