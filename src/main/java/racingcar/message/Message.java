package racingcar.message;

public enum Message {
    RACING_CAR_NAME_INPUT ("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPTS_COUNT_INPUT ("시도할 횟 수는 몇 회인가요?"),
    RACE_RESULT ("차수별 실행 결과"),
    RACE_USER_RESULT ("최종 우승자: %s");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
