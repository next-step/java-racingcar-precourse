package racinggame;

public enum Message {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NAME_RANGE("이름은 1자 이상 5자 이하만 가능합니다."),
    REQUEST_ATTEMPTS("시도할 회수는 몇회인가요?"),
    ATTEMPTS_INPUT_TYPE("시도할 회수는 숫자만 입력 가능합니다."),
    ATTEMPTS_RANGE("시도할 회수는 1이상이어야 합니다."),
    MOVE_RANGE("시스템 오류가 발생하였습니다. 자동차는 0~9 사이의 값으로 전진또는 정지합니다."),
    NO_WINNER("전진한 차량이 없습니다. 우승자는 없습니다."),
    PLAY_RESULT("실행 결과");

    private static final String preFixMsg = "[ERROR] ";
    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return preFixMsg + this.msg;
    }
}
