package game.view.constant;

public enum InputMessage {
    RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
    ATTEMPT_COUNT("시도할 회수는 몇회인가요?");

    private final String description;

    InputMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
