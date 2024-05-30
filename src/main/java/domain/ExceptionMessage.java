package domain;

public enum ExceptionMessage {
    INVALID_NAME_LENGTH("이름은 1자 이상 5자 이하만 가능합니다."),
    DUPLICATED_CAR_NAME("중복된 이름이 존재합니다."),
    INVALID_TRIAL_COUNT("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
