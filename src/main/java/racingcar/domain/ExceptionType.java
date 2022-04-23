package racingcar.domain;

public enum ExceptionType {
    IS_NAME_LENGTH_OVER_FIVE("이름의 크기가 5를 넘으면 안됩니다."),
    IS_CAR_QTY_UNDER_TWO("자동차의 개수는 최소 2대 이상이어야 합니다."),
    NOT_CONTAINS_CAR_NAMES_OVERLAP("자동차 이름은 중복되지 않아야 합니다."),
    INVALID_MOVE_COUNT_INPUT("이동가능 횟수는 1~9 사이의 정수이어야 합니다."),
    NOT_DECREASE_MOVE_COUNT("이동가능횟수가 0이어서 더 이상 이동할 수 없습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
