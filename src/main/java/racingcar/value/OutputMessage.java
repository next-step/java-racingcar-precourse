package racingcar.value;

public enum OutputMessage {

    INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRACK("시도할 회수는 몇회인가요?"),
    WINNERS("최종 우승자 : "),
    ERROR("[ERROR] : "),
    EXECUTE("실행결과");

    private final String content;

    OutputMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
