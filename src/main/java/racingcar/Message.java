package racingcar;

public enum Message {
    ERROR("[ERROR]");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String message(String message) {
        return this.message + " " + message;
    }
}
