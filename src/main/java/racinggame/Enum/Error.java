package racinggame.Enum;

public enum Error {
    ERROR_MSG_CARNAME("자동차의 공백없이 이름은 1자 이상 5자 미만이여야 합니다."),
    WRONG_ERR_NUMBER("잘못된 랜덤넘버 생성"),
    WRONG_INPUT_NUMBER("입력값이 숫자가 아닙니다. 숫자를 입력해 주세요");

    String msg;


    Error(String message) {
        String header = "[ERROR]";

        this.msg = header + message;
    }

    public String getMsg() {
        return msg;
    }
}
