package racinggame.exception;

public enum ErrorCode {
    EMPTY_NAME("자동차 이름은 필수입니다."),
    LENGTH_OVER_NAME("자동차 이름의 길이는 1자리 이상 5자 이하로 입력하여야 합니다."),
    EMPTY_COUNT("경주 시도 회수는 1회 이상이여야 합니다."),
    INVALID_TEXT("입력한 값이 올바르지 않습니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
