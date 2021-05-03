package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.*;

public class NameException extends RuntimeException {

    public static class DuplicateException extends RuntimeException {
        public DuplicateException() {
            super(NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public static class InvalidCharacterException extends RuntimeException {
        public InvalidCharacterException() {
            super(NAME_INVALID_CHARACTER_EXCEPTION.getMessage());
        }
    }

    public static class InvalidLengthException extends RuntimeException {
        public InvalidLengthException() {
            super(NAME_INVALID_LENGTH_EXCEPTION.getMessage());
        }
    }
}
