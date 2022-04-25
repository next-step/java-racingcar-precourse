package racingcar.message;

public enum RacingCarInfoMessage {

    INPUT_CAR_NAMES_INFO("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_RACE("시도할 횟수"),
    OUTPUT_RESULT("실행 결과"),
    OUTPUT_WINNER("최종 우승자: ");

    private final String message;

    RacingCarInfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
