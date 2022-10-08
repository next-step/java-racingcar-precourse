package racingcar.model.input.parser.number.of.round;

import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.ParseResultValue;

public class NumberOfRoundParseResult implements ParseResult<Integer> {
    private final ParseResultValue<Integer> numberOfRound;

    public NumberOfRoundParseResult(ParseResultValue<Integer> numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    @Override
    public ParseResultValue<Integer> getParseResultValue() {
        return numberOfRound;
    }

    public int getNumberOfRound() {
        return numberOfRound.getValue();
    }
}
