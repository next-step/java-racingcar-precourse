package racingcar.message;

public enum ErrorMessage {
    OUT_OF_CONDITION_ERROR ("전진하는 조건은 0에서 9를 벗어날 수 없습니다."),
    OUT_OF_NAME_LENGTH_ERROR ("차 이름은 5자 이하로 입력해주세요."),
    ONLY_NUMBER_ATTEMPT_COUNT_ERROR ("시도 횟수는 숫자만 입력할 수 있습니다."),
    MORE_THAN_ZERO_ATTEMPT_COUNT_ERROR ("시도 횟수는 1이상의 숫자여야만 합니다."),
    NOT_BLANK_NAME ("이름은 5자 이내로 꼭 입력해야 합니다."),
    ERROR ("[ERROR] ");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
