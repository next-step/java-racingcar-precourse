package racinggame.type;

public enum Messages {
    ERROR_SEED_NOT_IN_RANGE("시드값은 0 이상 9 이하의 정수여야 합니다."),
    ERROR_NAME_TOO_LONG_OR_EMPTY("이름은 1자이상 5자 이하여야 합니다."),
    ERROR_INVALID_CAR_NAME("CarName은 비어있을 수 없습니다."),
    ERROR_TRYTIMES_MUST_BE_GREATER_THAN_ZERO("시도 횟수는 최소 0 이상이어야 합니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
