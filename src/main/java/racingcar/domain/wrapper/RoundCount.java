package racingcar.domain.wrapper;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionType;
import racingcar.exception.StaticRacingException;
import racingcar.view.OutputView;

public class RoundCount {
    private static final String REGEX = "^[0-9]+";

    private final int count;

    public RoundCount(final String count) {
        validate(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }

    private void validate(final String count) {
        validNumber(count);
        validGreaterThanZero(Integer.parseInt(count));
    }

    private void validNumber(final String count) {
        if (!isMatched(count)) {
            OutputView.printErrorMessage(StaticRacingException.INVALID_ROUND_NOT_NUMBER_EXCEPTION.getMessage());
            throw StaticRacingException.INVALID_ROUND_NOT_NUMBER_EXCEPTION;
        }
    }

    private boolean isMatched(final String count) {
        return count.matches(REGEX);
    }

    private void validGreaterThanZero(final int count) {
        if (!isGreaterThenZero(count)) {
            OutputView.printErrorMessage(StaticRacingException.INVALID_ROUND_LESS_THEN_ZERO_EXCEPTION.getMessage());
            throw StaticRacingException.INVALID_ROUND_LESS_THEN_ZERO_EXCEPTION;
        }
    }

    private boolean isGreaterThenZero(final int count) {
        return count > 0;
    }
}
