package racingcar.domain;

import static racingcar.common.ErrorMessage.ROUND_ONLY_NUMBER;
import static racingcar.common.ErrorMessage.ROUND_NO_ZERO;

public class Round {

    private int round;

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int ZERO = 0;

    public Round(String round) {
        validNumberCheck(round);
        validZeroCheck(round);
        this.round = Integer.parseInt(round);
    }

    private void validZeroCheck(String round) {
        if (Integer.parseInt(round) != 0) {
            return;
        }
        throw new IllegalArgumentException(ROUND_NO_ZERO);
    }

    private void validNumberCheck(String round) {
        if (round.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ROUND_ONLY_NUMBER);
    }

    public int getRound() {
        return round;
    }
}
