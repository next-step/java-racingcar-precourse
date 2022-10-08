package racingcar.model.input.validator.number.of.round;

import racingcar.controller.user.input.UserInput;

public class IsNotIntegerParsable {
    private final UserInput userInput;

    public IsNotIntegerParsable(UserInput userInput) {
        this.userInput = userInput;
    }

    public boolean check() {
        try {
            final String userInputString = userInput.getUserInputValue().getValue();
            Integer.parseInt(userInputString);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
