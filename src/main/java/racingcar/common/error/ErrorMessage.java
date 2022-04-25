package racingcar.common.error;

public enum ErrorMessage {
    MSG_INVALID_DISTANCE("0이하의 거리값은 가질 수 없습니다."),
    MSG_INVALID_OVER_NAME_LENGTH("자동차의 이름은 %d자 이하 이어야 합니다."),
    MSG_INVALID_OVER_NAME_EMPTY("자동차의 이름은 공백일 수 없습니다."),
    MSG_INVALID_OVER_NAME_NULL("자동차의 이름은 NULL일 수 없습니다."),
    MSG_DUPLICATE_NAME("자동차의 이름은 중복 할 수 없습니다."),
    MSG_INVALID_NUMBER("0과 9사이의 숫자만 가능합니다."),
    MSG_INVALID_RACE_COUNT("양수만 가능합니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
