package racingcar.core.common.error;

public enum DistanceErrorCode implements ErrorCode {
    ONLY_ALLOW_POSITIVE_VALUE("거리는 양수만 가능합니다.");

    private final String errorMessage;

    DistanceErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }
}