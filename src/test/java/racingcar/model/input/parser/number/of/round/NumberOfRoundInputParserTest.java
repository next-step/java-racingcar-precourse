package racingcar.model.input.parser.number.of.round;

import org.junit.jupiter.api.Test;
import racingcar.controller.user.input.NumberOfRoundInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfRoundInputParserTest {
    @Test
    public void succeedInParseMethod() {
        UserInput userInput = new NumberOfRoundInput("5");
        InputParser<Integer> inputParser = new NumberOfRoundInputParser(userInput);
        ParseResult<Integer> parseResult = inputParser.parse();
        assertThat(parseResult.getParseResultValue().getValue()).isEqualTo(5);
    }
}
