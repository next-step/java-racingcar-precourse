package racingcar.controller.user.input;

public class NumberOfRoundInput implements UserInput {
    private final UserInputValue userInputValue;

    public NumberOfRoundInput(String value) {
        this.userInputValue = new UserInputValue(value);
    }

    @Override
    public UserInputValue getUserInputValue() {
        return userInputValue;
    }
}
