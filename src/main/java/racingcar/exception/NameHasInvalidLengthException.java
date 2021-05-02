package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.NUMBER_INVALID_LENGTH_EXCEPTION;

public class NameHasInvalidLengthException extends RuntimeException {
    public NameHasInvalidLengthException() {
        super(NUMBER_INVALID_LENGTH_EXCEPTION.getMessage());
    }

    public NameHasInvalidLengthException(String message) {
        super(message);
    }

    public NameHasInvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameHasInvalidLengthException(Throwable cause) {
        super(cause);
    }

    protected NameHasInvalidLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
