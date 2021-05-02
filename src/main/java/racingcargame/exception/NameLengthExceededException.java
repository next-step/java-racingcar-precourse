package racingcargame.exception;

public class NameLengthExceededException extends IllegalArgumentException {
    public NameLengthExceededException(String messageExceededNameLength) {
        super(messageExceededNameLength);
    }
}
