package racingcar.core.common.error;

public enum CommonErrorCode implements ErrorCode {
    NOT_ALLOW_NULL("null 값은 허용하지 않습니다."),
    NOT_ALLOW_EMPTY("공백은 허용하지 않습니다.");

    private final String errorMessage;

    CommonErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
