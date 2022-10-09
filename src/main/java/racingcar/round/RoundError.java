package racingcar.round;

public enum RoundError {

    NOT_NUMBER("Round number must be number"),
    NEGATIVE_NUMBER("Round number over 0");

    private String message;

    RoundError(String message) {
        this.message = message;
    }

    public String printMessage() {
        return String.format("[ERROR] %s", this.message);
    }
}
