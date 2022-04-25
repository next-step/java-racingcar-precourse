package racingcar.domain;

import racingcar.exception.InvalidParameterError;
import racingcar.message.ErrorMessage;

public class Round {
    private final int round;

    public Round(String inputRound) {
        validateRangeOfNumber(inputRound);
        this.round = Integer.parseInt(inputRound);
    }

    private void validateRangeOfNumber(String inputRound) {
        final String NUMBER_REGEX = "^[1-9]+$";
        if (inputRound.matches(NUMBER_REGEX)) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.ROUND_RANGE_ERROR);
    }

    public int getRound() {
        return this.round;
    }
}
