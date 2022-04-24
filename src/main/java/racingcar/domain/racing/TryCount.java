package racingcar.domain.racing;

import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_TRY;
import static racingcar.domain.constant.RacingGameExceptions.INVALID_TRY_COUNT_ERROR;

import racingcar.exception.RacingCarGameException;

public class TryCount {
    private final int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int get() {
        return count;
    }

    private void validate(int count) {
        if (count < MINIMUM_TRY) {
            throw illegalArgumentException(INVALID_TRY_COUNT_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }
}
