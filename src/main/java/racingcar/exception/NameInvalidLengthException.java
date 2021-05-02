package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.NUMBER_INVALID_LENGTH_EXCEPTION;

public class NameInvalidLengthException extends RuntimeException {
    public NameInvalidLengthException() {
        super(NUMBER_INVALID_LENGTH_EXCEPTION.getMessage());
    }

    public NameInvalidLengthException(String message) {
        super(message);
    }

    public NameInvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameInvalidLengthException(Throwable cause) {
        super(cause);
    }

    protected NameInvalidLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
