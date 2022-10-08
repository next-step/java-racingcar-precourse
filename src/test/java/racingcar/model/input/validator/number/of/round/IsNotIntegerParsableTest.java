package racingcar.model.input.validator.number.of.round;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.user.input.NumberOfRoundInput;
import racingcar.controller.user.input.UserInput;

import static org.assertj.core.api.Assertions.assertThat;

public class IsNotIntegerParsableTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void trueWhenNullOrEmpty(String input) {
        UserInput userInput = new NumberOfRoundInput(input);
        IsNotIntegerParsable isNotIntegerParsable = new IsNotIntegerParsable(userInput);
        assertThat(isNotIntegerParsable.check()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "!@#", "1234java", "    ", "3.0048"})
    public void trueWhenNonNumeric(String input) {
        UserInput userInput = new NumberOfRoundInput(input);
        IsNotIntegerParsable isNotIntegerParsable = new IsNotIntegerParsable(userInput);
        assertThat(isNotIntegerParsable.check()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "-1", "5678"})
    public void falseWhenIntegerParsable(String input) {
        UserInput userInput = new NumberOfRoundInput(input);
        IsNotIntegerParsable isNotIntegerParsable = new IsNotIntegerParsable(userInput);
        assertThat(isNotIntegerParsable.check()).isFalse();
    }
}
