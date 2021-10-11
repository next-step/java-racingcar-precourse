package racinggame.domain.constants;

public enum Messages {

    COMPLETE_FIRST_SENTENCE("최종우승자는 "),
    COMPLETE_LAST_SENTENCE(" 입니다."),
    INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ERROR("[ERROR] "),
    INPUT_GAME_COUNT("시도할 회수는 몇회인가요?");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
