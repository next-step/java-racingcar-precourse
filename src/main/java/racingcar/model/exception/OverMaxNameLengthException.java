package racingcar.model.exception;

public class OverMaxNameLengthException extends IllegalArgumentException {
    private static final String MAX_LENGTH_ERROR_MESSAGE = "이름은 5자를 초과할 수 없습니다.";

    public OverMaxNameLengthException() {
        super(MAX_LENGTH_ERROR_MESSAGE);
    }
}
