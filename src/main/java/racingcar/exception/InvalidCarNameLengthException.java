package racingcar.exception;

public class InvalidCarNameLengthException extends IllegalArgumentException {
    public InvalidCarNameLengthException(String message) {
        super(message);
    }
}
