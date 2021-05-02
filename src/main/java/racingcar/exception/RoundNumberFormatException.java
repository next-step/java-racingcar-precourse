package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.ROUND_NUMBER_FORMAT_EXCEPTION;

public class RoundNumberFormatException extends RuntimeException {
    public RoundNumberFormatException() {
        super(ROUND_NUMBER_FORMAT_EXCEPTION.getMessage());
    }

    public RoundNumberFormatException(String message) {
        super(message);
    }

    public RoundNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoundNumberFormatException(Throwable cause) {
        super(cause);
    }

    protected RoundNumberFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
