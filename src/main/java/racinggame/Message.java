package racinggame;

public enum Message {
    MOVE_RANGE("시스템 오류가 발생하였습니다. 자동차는 0~9 사이의 값으로 전진또는 정지합니다."),
    NO_WINNER("전진한 차량이 없습니다. 우승자는 없습니다.");

    private static final String preFixMsg = "[ERROR] ";
    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return preFixMsg + this.msg;
    }
}
