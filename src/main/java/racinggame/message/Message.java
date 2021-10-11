package racinggame.message;

public enum Message {
    RACING_CAR_NAME_INPUT ("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPTS_COUNT_INPUT ("시도할 횟 수는 몇 회인가요?"),
    RACE_RESULT ("실행 결과"),
    FINAL_WINNER_RESULT ("최종 우승자는 %s 입니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
