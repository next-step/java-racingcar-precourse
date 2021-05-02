package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.DUPLICATE_NAME_EXCEPTION;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException() {
        super(DUPLICATE_NAME_EXCEPTION.getMessage());
    }

    public DuplicateNameException(String message) {
        super(message);
    }

    public DuplicateNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateNameException(Throwable cause) {
        super(cause);
    }

    protected DuplicateNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
