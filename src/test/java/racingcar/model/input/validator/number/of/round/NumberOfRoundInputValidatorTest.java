package racingcar.model.input.validator.number.of.round;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.user.input.NumberOfRoundInput;
import racingcar.controller.user.input.UserInput;

import static org.assertj.core.api.Assertions.*;

public class NumberOfRoundInputValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void trueWhenNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInput userInput = new NumberOfRoundInput(input);
            NumberOfRoundInputValidator numberOfRoundInputValidator = new NumberOfRoundInputValidator(userInput);
            numberOfRoundInputValidator.validate();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "!@#$", "    ", "9.1773"})
    public void trueWhenNonInteger(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInput userInput = new NumberOfRoundInput(input);
            NumberOfRoundInputValidator numberOfRoundInputValidator = new NumberOfRoundInputValidator(userInput);
            numberOfRoundInputValidator.validate();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-9999"})
    public void trueWhenNegative(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInput userInput = new NumberOfRoundInput(input);
            NumberOfRoundInputValidator numberOfRoundInputValidator = new NumberOfRoundInputValidator(userInput);
            numberOfRoundInputValidator.validate();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "999111999"})
    public void falseWhenNonNegativeInteger(String input) {
        assertThatNoException().isThrownBy(() -> {
            UserInput userInput = new NumberOfRoundInput(input);
            NumberOfRoundInputValidator numberOfRoundInputValidator = new NumberOfRoundInputValidator(userInput);
            numberOfRoundInputValidator.validate();
        });
    }
}
