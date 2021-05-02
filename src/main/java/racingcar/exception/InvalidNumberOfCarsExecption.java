package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.INVALID_NUMBER_OF_CARS_EXCEPTION;

public class InvalidNumberOfCarsExecption extends RuntimeException {
    public InvalidNumberOfCarsExecption() {
        super(INVALID_NUMBER_OF_CARS_EXCEPTION.getMessage());
    }

    public InvalidNumberOfCarsExecption(String message) {
        super(message);
    }

    public InvalidNumberOfCarsExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfCarsExecption(Throwable cause) {
        super(cause);
    }

    protected InvalidNumberOfCarsExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
