package racingcar;

public enum Message {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    INPUT_GAME_COUNT("시도할 횟수는 몇회인가요?"),

    RESULT("실행결과"),

    WIN("최종 우승자");

    private final String Message;

    Message(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return this.Message;
    }

}
