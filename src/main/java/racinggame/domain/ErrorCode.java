package racinggame.domain;

public enum ErrorCode {

    NAME_EXCEEDED("[ERROR] 이름은 최대 5글자 입니다."),
    NAME_NOT_BLANK("[ERROR] 이름은 공백일 수 없습니다.");


    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
