package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.NUMBER_INVALID_CHARACTER_EXCEPTION;

public class NameHasInvalidCharacterException extends RuntimeException {
    public NameHasInvalidCharacterException() {
        super(NUMBER_INVALID_CHARACTER_EXCEPTION.getMessage());
    }

    public NameHasInvalidCharacterException(String message) {
        super(message);
    }

    public NameHasInvalidCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameHasInvalidCharacterException(Throwable cause) {
        super(cause);
    }

    protected NameHasInvalidCharacterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
