package racingcar.model.input.validator.car.names;

import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.Delimiter;

public class DelimiterAtTail {
    private final UserInput userInput;
    private final Delimiter delimiter;

    public DelimiterAtTail(UserInput userInput, Delimiter delimiter) {
        this.userInput = userInput;
        this.delimiter = delimiter;
    }

    public boolean check() {
        final String userInputString = userInput.getUserInputValue().getValue();
        final String delimiterString = delimiter.get();
        return userInputString.charAt(userInputString.length() - 1) ==
                delimiterString.charAt(delimiterString.length() - 1);
    }
}
