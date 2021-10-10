package racinggame.message;

public enum MessageType {

    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACE_NUMBER("시도할 회수는 몇회인가요?"),
    RACING_RESULT("실행 결과"),
    RACING_WINNER_START("최종 우승자는 "),
    RACING_WINNER_END(" 입니다.");


    private String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
