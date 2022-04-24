package racingcar.core.common.error;

public enum RoundErrorCode implements ErrorCode {

    ONLY_NUMBER_ALLOW("숫자만 입력 가능합니다."),
    NOT_ALLOW_ZERO("시도 횟수가 0입니다.");

    private final String errorMessage;

    RoundErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }
}
