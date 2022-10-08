package racingcar.model.input.parser.number.of.round;

import racingcar.controller.user.input.UserInput;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.ParseResultValue;

public class NumberOfRoundInputParser implements InputParser<Integer> {
    private final UserInput userInput;

    public NumberOfRoundInputParser(UserInput userInput) {
        this.userInput = userInput;
    }

    @Override
    public ParseResult<Integer> parse() {
        int numberOfRoundInt = Integer.parseInt(userInput.getUserInputValue().getValue());
        ParseResultValue<Integer> parseResultValue = new ParseResultValue<>(numberOfRoundInt);
        return new NumberOfRoundParseResult(parseResultValue);
    }
}
