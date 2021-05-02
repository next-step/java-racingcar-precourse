package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.ROUND_INVALID_RANGE_EXCEPTION;

public class RoundInvalidRangeException extends RuntimeException {
    public RoundInvalidRangeException() {
        super(ROUND_INVALID_RANGE_EXCEPTION.getMessage());
    }

    public RoundInvalidRangeException(String message) {
        super(message);
    }

    public RoundInvalidRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoundInvalidRangeException(Throwable cause) {
        super(cause);
    }

    protected RoundInvalidRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
