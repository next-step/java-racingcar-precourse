package racingcar.common.exception;

public enum ErrorMessage {
    ILLEGAL_INPUT_VALUE("[ERROR] 잘못된 입력값입니다."),
    CAN_NOT_NEGATIVE("[ERROR] 음수를 입력할 수 없습니다."),
    NAME_LENGTH_ERROR("[ERROR] 이름의 길이는 0이상 5이하만 가능 합니다."),
    CAN_NOT_ADD_SAME_CAR("[ERROR] 리스트에 동일한 Car가 존재합니다.");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
