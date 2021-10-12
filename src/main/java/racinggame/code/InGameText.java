package racinggame.code;

public enum InGameText {
    ENTER_CAR_LIST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_ROUND("시도할 회수는 몇회인가요?");

    private final String inGameText;

    InGameText(String inGameText) {
        this.inGameText = inGameText;
    }

    public String getValue() {
        return this.inGameText;
    }
}
