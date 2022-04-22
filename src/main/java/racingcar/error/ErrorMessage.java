package racingcar.error;

public enum ErrorMessage {
    INVALID_CAR_NAME_LENGTH("[ERROR] 이름은 5자 이하만 가능합니다."),
    INVALID_MOVE_COUNT("[ERROR] 시도할 회수는 숫자여야 합니다."),;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
