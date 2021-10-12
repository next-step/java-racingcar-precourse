package racinggame.config;

public enum ErrorMessage {
    ERROR_MESSAGE_CAR_NAME_DUPLICATE("[ERROR] 자동자 이름이 중복되었습니다."),
    ERROR_MESSAGE_CAR_NAME_LENGTH("[ERROR] 자동자 이름은 5글자 이하여야 합니다."),
    ERROR_MESSAGE_ATTEMPT_COUNT("[ERROR] 시도 횟수는 1이상의 정수만 가능합니다."),

    ;

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
