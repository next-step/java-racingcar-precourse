package racingcar.enums;

public enum ErrorMsgEnum {
    TOO_LONG_NAME_ERROR_MSG("[ERROR] 이름 길이가 너무 깁니다."),
    NOT_AVAILABLE_NUMBER_ERROR_MSG("[ERROR] 숫자 값이 아닙니다."),
    NOT_AVAILABLE_COMMA_ERROR_MSG("[ERROR] 콤마 위치가 이상합니다.");

    private String value;

    private ErrorMsgEnum(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
