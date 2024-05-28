package validator;

import org.junit.jupiter.api.Test;
import racinggame.validator.InputValidator;
import racinggame.validator.RacingGameInputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameInputValidatorTest {

    @Test
    void isValidateCarNames_ValidNames() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        validator.isValidateCarNames("전남대,부산대,경북대,충남대,강원대");
    }

    @Test
    void isValidateCarNames_InvalidNames_TooLong() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidateCarNames("카카오테크캠퍼스");
        });
    }

    @Test
    void isValidateCarNames_InvalidNames_EmptyName() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidateCarNames("전남대,,부산대");
        });
    }

    @Test
    void isValidateInputNum_ValidCount() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        validator.isValidateInputNum("5");
    }

    @Test
    void isValidateInputNum_InvalidCount_NonPositive() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidateInputNum("0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidateInputNum("-1");
        });
    }

    @Test
    void isValidateInputNum_InvalidCount_NonNumeric() {
        RacingGameInputValidator validator = new RacingGameInputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidateInputNum("하하하");
        });
    }

}
