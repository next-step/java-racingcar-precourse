package game.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import game.exception.constant.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountValidatorTest {

    AttemptCountValidator attemptCountValidator = AttemptCountValidator.getInstance();

    @ParameterizedTest(name = "{0}은 적절한 시도 횟수 입력입니다")
    @ValueSource(strings = {"5", "10", "100"})
    void 적절한_시도_횟수_입력에_대해_예외를_던지지_않습니다(String input) {
        assertDoesNotThrow(() -> attemptCountValidator.validate(input));
    }

    @ParameterizedTest(name = "{0}은 숫자가 아닌 입력")
    @ValueSource(strings = {"thiago,sil", "enzo", "a", "", " "})
    void 숫자가_아닌_입력값에_대하여_예외를_발생시킵니다(String input) {
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class, () -> attemptCountValidator.validate(input));

        assertThat(error.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

    @ParameterizedTest(name = "{0}은 1보다 작은 입력")
    @ValueSource(strings = {"-1", "-100", "-99999", "0"})
    void 입력이_1보다_작은_입력값에_대하여_예외를_발생시킵니다(String input) {
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class, () -> attemptCountValidator.validate(input));

        assertThat(error.getMessage()).isEqualTo(
            ErrorMessage.INVALID_ATTEMPT_COUNT_INPUT.getMessage());
    }

}