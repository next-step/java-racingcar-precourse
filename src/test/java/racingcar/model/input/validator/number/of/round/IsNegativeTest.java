package racingcar.model.input.validator.number.of.round;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.user.input.NumberOfRoundInput;
import racingcar.controller.user.input.UserInput;

import static org.assertj.core.api.Assertions.assertThat;

public class IsNegativeTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1234"})
    public void falseWhenZeroOrPositive(String input) {
        UserInput userInput = new NumberOfRoundInput(input);
        IsNegative isNegative = new IsNegative(userInput);
        assertThat(isNegative.check()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-9876"})
    public void falseWhenNagative(String input) {
        UserInput userInput = new NumberOfRoundInput(input);
        IsNegative isNegative = new IsNegative(userInput);
        assertThat(isNegative.check()).isTrue();
    }
}
