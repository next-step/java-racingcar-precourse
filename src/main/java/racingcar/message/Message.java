package racingcar.message;

public enum Message {


    INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ERROR("[ERROR] 잘못된 입력값 입니다. 다시 입력해 주세요."),
    INPUT_GAME_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    COMPLETE_FIRST_SENTENCE("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
