package racingcar.view;

public class PrintMessage {
    private final String message;

    private PrintMessage(String message) {
        this.message = message;
    }

    public static PrintMessage of(String message) {
        return new PrintMessage(message);
    }

    @Override
    public String toString() {
        return message;
    }
}
