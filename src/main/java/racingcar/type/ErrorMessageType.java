package racingcar.type;

public enum ErrorMessageType {

    INPUT_NOT_ALLOW_BLANK("공백은 입력할 수 없습니다."),
    NOT_ALLOW_GREATER_THAN_FIVE("자동차 이름은 5자 이하만 가능합니다."),
    TRY_COUNT_NOT_ALLOW_LESS_THAN_ONE("시도할 횟수는 0보다 큰 숫자로 입력해주세요."),
    INPUT_ONLY_ALLOW_NUMBER("숫자만 입력해주세요."),
    LESS_THAN_START_INCLUSIVE("범위보다 값이 작을 수 없습니다."),
    GREATER_THAN_END_INCLUSIVE("범위보다 값이 클 수 없습니다.");

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
