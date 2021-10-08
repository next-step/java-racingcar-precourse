package racinggame.model.enums;

public enum Error {
    INVALID_CAR_NAME("자동차 이름을 정확히 입력해주세요"),
    INVALID_CAR_NAME_RANGE("자동차 이름은 5자 이하여야 합니다.")
    ;

    private static final String prefix = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message() {
        return prefix + message;
    }
}
