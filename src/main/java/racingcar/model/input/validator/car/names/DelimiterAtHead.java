package racingcar.model.input.validator.car.names;

import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.Delimiter;

public class DelimiterAtHead {
    private final UserInput userInput;
    private final Delimiter delimiter;

    public DelimiterAtHead(UserInput userInput, Delimiter delimiter) {
        this.userInput = userInput;
        this.delimiter = delimiter;
    }

    public boolean check() {
        return userInput.getUserInputValue().getValue().charAt(0) == delimiter.get().charAt(0);
    }
}
