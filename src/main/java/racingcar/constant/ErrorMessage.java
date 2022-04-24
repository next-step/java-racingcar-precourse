package racingcar.constant;

public enum ErrorMessage {
    EMPTY_CAR_NAME("[ERROR] 자동차 이름을 입력해 주세요"),
    WRONG_CAR_NAME("[ERROR] 자동차 이름은 5자 이하여야 합니다."),
    OVERLAP_CAR_NAME("[ERROR] 자동차 이름이 중복되었습니다."),
    EMPTY_RACE_NUMBER("[ERROR] 경주 횟수를 입력해 주세요"),
    WRONG_RACE_NUMBER("[ERROR] 경주 횟수는 숫자여야 합니다."),
    IS_ZERO("[ERROR] 경주 횟수 0보다 커야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
