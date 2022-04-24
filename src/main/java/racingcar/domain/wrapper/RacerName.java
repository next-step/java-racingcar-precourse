package racingcar.domain.wrapper;

import racingcar.exception.StaticRacingException;
import racingcar.view.OutputView;

public class RacerName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public RacerName(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        validNull(name);
        validLength(name);
    }

    private void validNull(final String name) {
        if (name == null) {
            OutputView.printErrorMessage(StaticRacingException.INVALID_RACING_NAME_NOT_NULL_EXCEPTION.getMessage());
            throw StaticRacingException.INVALID_RACING_NAME_NOT_NULL_EXCEPTION;
        }
    }

    private void validLength(final String name) {
        if (!isValidLength(name.length())) {
            OutputView.printErrorMessage(StaticRacingException.INVALID_RACING_NAME_LENGTH_EXCEPTION.getMessage());
            throw StaticRacingException.INVALID_RACING_NAME_LENGTH_EXCEPTION;
        }
    }

    private boolean isValidLength(final int length) {
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }
}
