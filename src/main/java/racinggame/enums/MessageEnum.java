package racinggame.enums;

public enum MessageEnum {
    INITIAL_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INITIAL_INPUT_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?");

    String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
