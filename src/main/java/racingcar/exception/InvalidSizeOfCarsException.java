package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.INVALID_SIZE_OF_CARS_EXCEPTION;

public class InvalidSizeOfCarsException extends RuntimeException {
    public InvalidSizeOfCarsException() {
        super(INVALID_SIZE_OF_CARS_EXCEPTION.getMessage());
    }

    public InvalidSizeOfCarsException(String message) {
        super(message);
    }

    public InvalidSizeOfCarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSizeOfCarsException(Throwable cause) {
        super(cause);
    }

    protected InvalidSizeOfCarsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
