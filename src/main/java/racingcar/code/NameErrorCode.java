package racingcar.code;

public enum NameErrorCode implements ErrorCode {

    LENGTH("자동차 이름은 5자 이하만 가능합니다."),

    NULL("자동차 이름은 NULL 값이 불가능합니다."),

    EMPTY("자동차 이름은 공백 값이 불가능합니다.");

    private final String message;

    NameErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
