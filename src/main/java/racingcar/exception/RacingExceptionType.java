package racingcar.exception;

public enum RacingExceptionType {
    INVALID_RACING_NAME_NOT_NULL("레이서 이름은 필수 값 입니다."),
    INVALID_RACING_NAME_LENGTH("레이서 이름은 5자리 이하 여야 합니다."),
    INVALID_MOVE_RANGE("이동 범위는 0 ~ 9 값 이여야 합니다."),
    INVALID_ROUND_NOT_NUMBER("시도 횟수는 숫자만 입력 가능 합니다."),
    INVALID_ROUND_LESS_THEN_ZERO("시도 횟수는 0보다 큰값만 가능 합니다.");

    private final String message;
    private static final String MESSAGE_PREFIX = "[ERROR] ";

    RacingExceptionType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + message;
    }
}
