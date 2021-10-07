package racinggame.type;

public enum Messages {
    ERROR_SEED_NOT_IN_RANGE("시드값은 0 이상 9 이하의 정수여야 합니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
