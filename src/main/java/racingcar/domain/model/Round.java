package racingcar.domain.model;

import racingcar.core.common.error.CommonErrorCode;
import racingcar.core.common.error.RoundErrorCode;

import java.util.Objects;

public class Round {

    private static final String REGEX = "[0-9]+";
    private static final String ZERO = "0";

    private final int round;

    public Round(final String round) {
        validate(round);
        this.round = Integer.parseInt(round);
    }

    public int getRound() {
        return round;
    }

    private void validate(final String round) {
        validateNull(round);
        validateEmpty(round);
        validateNumber(round);
        validateZero(round);
    }

    private void validateNull(final String round) {
        if (Objects.isNull(round)) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage());
        }
    }

    private void validateEmpty(final String round) {
        String trimName = round.trim();
        if (trimName.isEmpty()) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage());
        }
    }

    private void validateNumber(final String round) {
        if (!round.matches(REGEX)) {
            throw new IllegalArgumentException(RoundErrorCode.ONLY_NUMBER_ALLOW.getErrorMessage());
        }
    }

    private void validateZero(final String round) {
        if (Objects.equals(round, ZERO)) {
            throw new IllegalArgumentException(RoundErrorCode.NOT_ALLOW_ZERO.getErrorMessage());
        }
    }
}