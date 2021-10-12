package racinggame.exception;

public enum RacingGameErrorCode {
    INVALID_CAR_NAME("5글자 초과 또는 비어있는 이름으로 자동차를 생성할 수 없습니다."),
    INVALID_ATTEMPT_NUMBER("1회 이상의 횟수를 입력해주세요.");

    private final String message;

    RacingGameErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
