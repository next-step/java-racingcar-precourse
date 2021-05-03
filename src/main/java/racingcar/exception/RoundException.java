package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.*;

public class RoundException {
    public static class InvalidRangeException extends RuntimeException {
        public InvalidRangeException() {
            super(ROUND_INVALID_RANGE_EXCEPTION.getMessage());
        }
    }

    public static class NumberFormatException extends RuntimeException {
        public NumberFormatException() {
            super(ROUND_NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static class ExceedExecutableNumberException extends RuntimeException {
        public ExceedExecutableNumberException() {
            super(ROUND_EXCEED_EXECUTABLE_NUMBER.getMessage());
        }
    }
}
