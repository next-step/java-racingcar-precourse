package racingcar.domain;

import racingcar.util.Constants;
import racingcar.util.RegexUtil;

public class RacingRound {
    private final int round;

    public RacingRound(String round) {
        validateRound(round);
        this.round = Integer.parseInt(round);
    }

    public int toInt() {
        return round;
    }

    private void validateRound(String round) {
        if (!RegexUtil.match(Constants.REGEX_NOT_NUMBER, round)) {
            throw new IllegalArgumentException(Constants.ERR_NOT_NUMBER);
        }
        if (RegexUtil.match(Constants.REGEX_NOT_ZERO, round)) {
            throw new IllegalArgumentException(Constants.ERR_NOT_ZERO);
        }
    }
}
