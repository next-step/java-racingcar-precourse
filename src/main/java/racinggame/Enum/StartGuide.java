package racinggame.Enum;

public enum StartGuide {
    NAME_MSG("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_MSG("시도할 횟수는 몇회인가요?"),
    GAME_START_MSG("실행 결과");

    String msg;

    StartGuide(String s) {
        this.msg = s;
    }

    public String getMsg() {
        return msg;
    }
}
