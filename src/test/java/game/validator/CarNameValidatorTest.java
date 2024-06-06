package game.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import game.exception.constant.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    CarNameValidator carNameValidator = CarNameValidator.getInstance();

    @ParameterizedTest(name = "{0}은 적절한 이름 입력입니다")
    @ValueSource(strings = {"en.zo,silva,james","silva","_enzo,en zo,enzo "})
    void 적절한_이름_입력에_대해_예외를_던지지_않습니다(String input) {
        assertDoesNotThrow(() -> carNameValidator.validate(input));
    }

    @ParameterizedTest(name = "{0}은 길이를 초과한 이름 입력입니다")
    @ValueSource(strings = {"thiago,sil   ","en      ,zo"})
    void 부적절한_이름_길이는_예외를_발생시킵니다(String input) {
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class, () -> carNameValidator.validate(input));

        assertThat(error.getMessage()).isEqualTo(ErrorMessage.EXCEED_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest(name = "{0}은 중복이 존재하는 이름 입력입니다")
    @ValueSource(strings = {"enzo,bruno,enzo","james,james,james"})
    void 중복이_존재하는_이름은_예외를_발생시킵니다(String input) {
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class, () -> carNameValidator.validate(input));

        assertThat(error.getMessage()).isEqualTo(ErrorMessage.DUPLICATE_NAME_FOUND.getMessage());
    }

}