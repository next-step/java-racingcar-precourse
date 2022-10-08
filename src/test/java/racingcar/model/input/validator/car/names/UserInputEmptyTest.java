package racingcar.model.input.validator.car.names;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.input.validator.UserInputEmpty;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputEmptyTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void trueWhenIsNullOrEmpty(String userInputString) {
        UserInput userInput = new CarNamesInput(userInputString);
        UserInputEmpty userInputEmpty = new UserInputEmpty(userInput);
        assertThat(userInputEmpty.check()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "abcd"})
    public void falseWhenNeitherNullOrEmpty(String userInputString) {
        UserInput userInput = new CarNamesInput(userInputString);
        UserInputEmpty userInputEmpty = new UserInputEmpty(userInput);
        assertThat(userInputEmpty.check()).isFalse();
    }
}
