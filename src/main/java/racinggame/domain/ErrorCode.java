package racinggame.domain;

public enum ErrorCode {

    NAME_EXCEEDED("[ERROR] 이름은 최대 5글자 입니다."),
    NAME_NOT_BLANK("[ERROR] 이름은 공백일 수 없습니다."),
    IS_NOT_NUMBER("[ERROR] 숫자를 입력해주세요");


    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
