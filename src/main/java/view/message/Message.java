package view.message;

public enum Message {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분"),
    TRIAL_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),

    GAME_RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자"),
    EXECUTION_RESULT_MESSAGE("실행 결과");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
