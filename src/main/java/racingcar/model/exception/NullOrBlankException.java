package racingcar.model.exception;

public class NullOrBlankException extends IllegalArgumentException {
    private static final String MESSAGE = "이름은 공백 또는 null 이 될 수 없습니다.";

    public NullOrBlankException() {
        super(MESSAGE);
    }
}
