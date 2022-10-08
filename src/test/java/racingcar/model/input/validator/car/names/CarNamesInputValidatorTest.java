package racingcar.model.input.validator.car.names;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.CarNamesInputDelimiter;
import racingcar.model.delimiter.Delimiter;

import static org.assertj.core.api.Assertions.*;

public class CarNamesInputValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void thrownWhenIsNullOrEmpty(String userInputString) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInput userInput = new CarNamesInput(userInputString);
            Delimiter delimiter = new CarNamesInputDelimiter(",");
            CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator(userInput, delimiter);
            carNamesInputValidator.validate();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {",test", "case,"})
    public void thrownWhenUserInputStartsOrEndsWithDelimiter(String userInputString) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            UserInput userInput = new CarNamesInput(userInputString);
            Delimiter delimiter = new CarNamesInputDelimiter(",");
            CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator(userInput, delimiter);
            carNamesInputValidator.validate();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"onlyOne", "one, two, three"})
    public void notThrownWhenValidUserInput(String userInputString) {
        assertThatNoException().isThrownBy(() -> {
            UserInput userInput = new CarNamesInput(userInputString);
            Delimiter delimiter = new CarNamesInputDelimiter(",");
            CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator(userInput, delimiter);
            carNamesInputValidator.validate();
        });
    }
}
