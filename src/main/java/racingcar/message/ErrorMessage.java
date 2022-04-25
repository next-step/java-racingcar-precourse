package racingcar.message;

public enum ErrorMessage {
    OUT_OF_NAME_LENGTH_ERROR ("[ERROR] 차 이름은 5자 이하로 입력해주세요."),
    NUMBER_ATTEMPT_COUNT_ERROR ("[ERROR] 시도 횟수는 숫자만 입력할 수 있습니다."),
    MORE_THAN_ZERO_ATTEMPT_COUNT_ERROR ("[ERROR] 시도 횟수는 1이상의 숫자여야만 합니다."),
    BLANK_NAME("[ERROR] 이름은 5자 이내로 꼭 입력해야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
