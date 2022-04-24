package racingcar.constant;

public enum Hint {
    HINT_ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표("
        + Sign.SPLIT_SIGN.getSign() + ")기준으로 구분)"),
    HINT_ASK_RACE_NUMBER("시도할 회수는 몇회인가요?"),
    HINT_RESULT("실행 결과"),
    HINT_WINNER("최종 우승자: ");

    private final String message;

    Hint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
