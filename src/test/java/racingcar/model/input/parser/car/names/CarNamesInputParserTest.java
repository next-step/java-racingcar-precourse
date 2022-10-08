package racingcar.model.input.parser.car.names;

import org.junit.jupiter.api.Test;
import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.CarNamesInputDelimiter;
import racingcar.model.delimiter.Delimiter;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesInputParserTest {
    @Test
    public void succeedInParseMethod() {
        UserInput userInput = new CarNamesInput("a01, b33 , c44");
        Delimiter delimiter = new CarNamesInputDelimiter(",");
        InputParser<ArrayList<String>> inputParser = new CarNamesInputParser(userInput, delimiter);
        ParseResult<ArrayList<String>> parseResult = inputParser.parse();
        assertThat(parseResult.getParseResultValue().getValue().size()).isEqualTo(3);
        assertThat(parseResult.getParseResultValue().getValue().get(0)).isEqualTo("a01");
        assertThat(parseResult.getParseResultValue().getValue().get(1)).isEqualTo("b33");
        assertThat(parseResult.getParseResultValue().getValue().get(2)).isEqualTo("c44");
    }
}
