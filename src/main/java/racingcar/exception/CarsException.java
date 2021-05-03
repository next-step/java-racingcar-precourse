package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.CARS_INVALID_COUNT_EXCEPTION;

public class CarsException extends RuntimeException {
    public static class InvalidCountException extends RuntimeException {
        public InvalidCountException() {
            super(CARS_INVALID_COUNT_EXCEPTION.getMessage());
        }
    }
}
