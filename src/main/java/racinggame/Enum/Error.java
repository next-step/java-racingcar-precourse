package racinggame.Enum;

public enum Error {
    ERROR_MSG_CARNAME("자동차의 공백없이 이름은 1자 이상 5자 미만이여야 합니다."),
    WRONG_ERR_NUMBER("잘못된 랜덤넘버 생성");
    String msg;


    Error(String message) {
        String header = "[ERROR]";

        this.msg = header + message;
    }

    public String getMsg() {
        return msg;
    }
}
