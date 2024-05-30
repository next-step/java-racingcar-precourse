package util;

public enum GeneralExceptionMessage {
    INVALID_MIN_MAX("min은 max보다 작거나 같아야 합니다.");

    private final String message;

    GeneralExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
