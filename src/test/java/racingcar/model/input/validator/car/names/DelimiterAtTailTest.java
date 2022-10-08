package racingcar.model.input.validator.car.names;

import org.junit.jupiter.api.Test;
import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.CarNamesInputDelimiter;
import racingcar.model.delimiter.Delimiter;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterAtTailTest {
    @Test
    public void trueWhenEndsWithDelimiter() {
        UserInput userInput = new CarNamesInput("abcd,");
        Delimiter delimiter = new CarNamesInputDelimiter(",");
        DelimiterAtTail delimiterAtTail = new DelimiterAtTail(userInput, delimiter);
        assertThat(delimiterAtTail.check()).isTrue();
    }

    @Test
    public void falseWhenNotEndWithDelimiter() {
        UserInput userInput = new CarNamesInput("abcd,3456,memo");
        Delimiter delimiter = new CarNamesInputDelimiter(",");
        DelimiterAtTail delimiterAtTail = new DelimiterAtTail(userInput, delimiter);
        assertThat(delimiterAtTail.check()).isFalse();
    }
}
