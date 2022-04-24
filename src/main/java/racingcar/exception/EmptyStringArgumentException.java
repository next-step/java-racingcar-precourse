package racingcar.exception;

public class EmptyStringArgumentException extends IllegalArgumentException {
    public EmptyStringArgumentException(String message) {
        super(message);
    }
}
