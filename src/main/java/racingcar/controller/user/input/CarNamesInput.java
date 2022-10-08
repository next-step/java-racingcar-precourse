package racingcar.controller.user.input;

public class CarNamesInput implements UserInput {
    private final UserInputValue userInputValue;

    public CarNamesInput(String value) {
        this.userInputValue = new UserInputValue(value);
    }

    @Override
    public UserInputValue getUserInputValue() {
        return userInputValue;
    }
}
