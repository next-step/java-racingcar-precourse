package exception;

public enum ErrorMessage {

    DUPLICATED_NAME("[ERROR] 중복된 자동차 이름은 사용할 수 없습니다."),
    NAME_LENGTH_MORE_THAN_FIVE("[ERROR] 자동차 이름은 5자 이하여야 합니다."),
    ATTEMPT_NOT_INTEGER("[ERROR] 시도 횟수는 정수를 입력해야 합니다."),
    ATTEMPT_LESS_THAN_ONE("[ERROR] 시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
