package racingcar.model.round;

import racingcar.model.input.parser.ParseResult;

public class NumberOfRound implements Round {
    private int roundLeft;

    public NumberOfRound(ParseResult<Integer> parseResultNumberOfRound) {
        this.roundLeft = parseResultNumberOfRound.getParseResultValue().getValue();
    }

    @Override
    public boolean hasNext() {
        return 0 < roundLeft;
    }

    @Override
    public void next() {
        --roundLeft;
    }
}
