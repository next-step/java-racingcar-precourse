package racinggame;

public enum RaceErrorCode {
    INVALID_CAR_NAME_LENGTH("[ERROR] : 잘못된 길이의 자동차 이름 입력입니다. 각 자동차의 이름을 1자~5자 이하로 입력하세요."),
    INVALID_FORMAT_ITERATION_COUNT("[ERROR] : 잘못된 범위의 자동자 경주 회수 입력입니다. 1 ~ " + Integer.MAX_VALUE + "범위의 숫자로 입력하세요."),
    ;

    private final String message;

    RaceErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
