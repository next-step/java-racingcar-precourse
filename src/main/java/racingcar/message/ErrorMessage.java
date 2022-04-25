package racingcar.message;

public enum ErrorMessage {

    CAR_NAME_ERROR("자동차 이름은 1~5자여야 합니다."),
    DISTANCE_DRIVEN_ERROR("주행거리는 0보다 작을 수 없습니다.");

    private static final String prefix = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
