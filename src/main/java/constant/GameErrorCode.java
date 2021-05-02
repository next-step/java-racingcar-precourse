package constant;

public enum GameErrorCode {
    /**
     * Car name error
     */
    CAR_NAME_EMPTY("자동차 이름이 비어있습니다."),
    CAR_NAME_SIZE_OVER("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_OVERLAP("중복된 자동차 이름이 있습니다.");

    private String msg;

    GameErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
