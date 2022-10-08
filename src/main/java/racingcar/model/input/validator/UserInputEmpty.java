package racingcar.model.input.validator;

import racingcar.controller.user.input.UserInput;

public class UserInputEmpty {
    private final UserInput userInput;

    public UserInputEmpty(UserInput userInput) {
        this.userInput = userInput;
    }

    public boolean check() {
        final String userInputString = userInput.getUserInputValue().getValue();
        return userInputString == null || userInputString.length() == 0;
    }
}
