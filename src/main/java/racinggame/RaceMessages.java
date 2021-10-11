package racinggame;

public enum RaceMessages {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ITERATION_COUNT("시도할 회수는 몇회인가요?"),
    PRINT_WINNER_PREFIX("최종 우승자는 "),
    PRINT_WINNER_POSTFIX(" 입니다.")
    ;

    private final String message;

    RaceMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
