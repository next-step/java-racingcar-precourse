package racingcar.car;

public enum CarErrorStatus {
    BLANK("Name empty are not allowed"),
    NAME_OVER_LENGTH("Name do not over length 5");

    private final String message;

    CarErrorStatus(String message) {
        this.message = message;
    }

    public String printMessage() {
        return String.format("[ERROR] %s", this.message);
    }
}
