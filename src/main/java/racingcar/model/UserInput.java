package racingcar.model;

import racingcar.constant.InfoMessage;

public class UserInput {
    private final String input;

    public UserInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(
                    String.format("%s: input cannot be null", InfoMessage.ERROR_MESSAGE_BEGIN));
        }
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
