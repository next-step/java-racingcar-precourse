package racingcar.message;

public enum ErrorMessage {

    CAR_NAME_ERROR("자동차 이름은 1~5자여야 합니다."),
    DISTANCE_DRIVEN_ERROR("주행거리는 0보다 작을 수 없습니다."),
    NUMBER_OF_RACE_NOT_NUMBER("시도 할 횟수는 숫자 값이어야 합니다."),
    NUMBER_OF_RACE_THEN_ZERO("시도 할 횟수는 0보다 커야 합니다.");

    private static final String prefix = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
