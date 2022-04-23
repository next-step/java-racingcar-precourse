package racingcar.messenger;

public enum PrintMessage {

    CAR_STATUS("%s : %s"),
    WINNER("최종 우승자: %s");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
