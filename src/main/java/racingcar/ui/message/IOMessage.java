package racingcar.ui.message;

public enum IOMessage {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ROUND("시도할 회수는 몇회인가요?"),
    EXECUTE_RESULT("실행결과"),
    WINNER_SUFFIX("가 최종 우승했습니다.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
