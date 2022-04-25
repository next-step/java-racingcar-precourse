package racingcar.model.exception;

public class OverTryCountException extends IllegalArgumentException {
    private static final String MESSAGE = "시도 횟수를 초과하였습니다.";

    public OverTryCountException() {
        super(MESSAGE);
    }
}
