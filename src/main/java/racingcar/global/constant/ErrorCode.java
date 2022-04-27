package racingcar.global.constant;

public enum ErrorCode {
    NOT_INPUT("입력값이 없습니다."),
    INVALID_CAR_ZERO_NAME_LENGTH("자동차 이름은 필수적으로 입력되어야 합니다."),
    INVALID_CAR_LENGTH("자동차 이름의 길이는 최대 5자까지 입력 가능합니다."),
    DUPLICATED_CAR_NAME("중복된 자동차 이름이 존재합니다."),
    INVALID_INPUT_DATA("옳바르지 않은 입력 데이터 입니다."),
    INVALID_LAP_SIZE("0과 20 사이의 숫자를 입력해 주세요.");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorCode (String message){
        this.message = message;
    }
}
