package racingcar;

public enum InputType {

    CAR_NAME("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
    , MOVE_COUNT("시도할 회수는 몇회인가요?");

    private final String guideMessage;

    InputType(final String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getGuideMessage() {
        return this.guideMessage;
    }

}
