package racingcar.constant;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    CAR_NAME_WRONG("자동차 이름은 1자 이상 5자 이하입니다."),
    CAR_NAME_SPACE("자동차 이름에 공백이 포함되어 있습니다."),
    CAR_NAME_DUPLICATE("중복된 자동차 이름이 있습니다."),
    REPEAT_TIME_NON_POSITIVE("시도할 횟수는 0보다 커야 합니다."),
    REPEAT_TIME_NON_NUMERIC("시도할 횟수는 숫자여야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
