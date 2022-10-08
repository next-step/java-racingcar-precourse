package racingcar.model.input.validator.number.of.round;

import racingcar.controller.user.input.UserInput;

public class IsNegative {
    private final UserInput userInput;

    public IsNegative(UserInput userInput) {
        this.userInput = userInput;
    }

    public boolean check() {
        final String userInputString = userInput.getUserInputValue().getValue();
        int userInputInt = Integer.parseInt(userInputString);
        return userInputInt < 0;
    }
}
