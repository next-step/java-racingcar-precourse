package racingcar.model.input.validator.number.of.round;

import racingcar.controller.user.input.UserInput;
import racingcar.model.input.validator.InputValidator;
import racingcar.model.input.validator.UserInputEmpty;
import racingcar.model.input.validator.ValidateResult;

public class NumberOfRoundInputValidator implements InputValidator {
    private final UserInput userInput;

    public NumberOfRoundInputValidator(UserInput userInput) {
        this.userInput = userInput;
    }

    @Override
    public ValidateResult validate() {
        isUserInputItselfValid();
        isTrimmedUserInputValid();
        return new NumberOfRoundValidateResult();
    }

    private boolean isUserInputItselfValid() {
        UserInputEmpty userInputItselfEmpty = new UserInputEmpty(userInput);
        if (userInputItselfEmpty.check()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isTrimmedUserInputValid() {
        IsNotIntegerParsable isNotIntegerParsable = new IsNotIntegerParsable(userInput);
        IsNegative isNegative = new IsNegative(userInput);
        if (isNotIntegerParsable.check() || isNegative.check()) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
