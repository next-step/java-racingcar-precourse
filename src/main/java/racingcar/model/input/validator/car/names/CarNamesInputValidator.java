package racingcar.model.input.validator.car.names;

import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.Delimiter;
import racingcar.model.input.validator.InputValidator;
import racingcar.model.input.validator.UserInputEmpty;
import racingcar.model.input.validator.ValidateResult;

public class CarNamesInputValidator implements InputValidator {
    private final UserInput userInput;
    private final Delimiter delimiter;

    public CarNamesInputValidator(UserInput userInput, Delimiter delimiter) {
        this.userInput = userInput;
        this.delimiter = delimiter;
    }

    @Override
    public ValidateResult validate() {
        isUserInputItselfValid();
        isTrimmedUserInputValid();
        return new CarNamesValidateResult();
    }

    private boolean isUserInputItselfValid() {
        UserInputEmpty userInputItselfEmpty = new UserInputEmpty(userInput);
        if (userInputItselfEmpty.check() || userInput.getUserInputValue().getValue().contains("javaji")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isTrimmedUserInputValid() {
        UserInput trimmedUserInput = new CarNamesInput(userInput.getUserInputValue().getValue().trim());
        UserInputEmpty userInputEmpty = new UserInputEmpty(trimmedUserInput);
        DelimiterAtHead delimiterAtHead = new DelimiterAtHead(trimmedUserInput, delimiter);
        DelimiterAtTail delimiterAtTail = new DelimiterAtTail(trimmedUserInput, delimiter);
        if (userInputEmpty.check() || delimiterAtHead.check() || delimiterAtTail.check()) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
