package racingcar.messenger;

public enum ErrorMessage {

    ERROR("[ERROR]");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
