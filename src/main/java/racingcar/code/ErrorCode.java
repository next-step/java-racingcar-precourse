package racingcar.code;

public enum ErrorCode {

    CAR_NAVE_OVER_MAX_LENGTH("이름의 길이가 5보다 큽니다."),
    CAR_NAME_NULL("차의 이름이 null 입니다."),
    CAR_NAME_IS_EMPTY("차의 이름이 공백입니다."),
    IS_NOT_NUMBERIC("숫자를 입력해 주세요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX + this.errorMessage;
    }
}
