package racingcar.exception;

public class InputWrongValueException extends IllegalArgumentException {

    private static final String ERROR = "[ERROR] ";

    private final String message;

    public InputWrongValueException(String message) {
        super(message);
        this.message = message;
    }

    public void printMessage() {
        System.out.println(ERROR + this.message);
    }
}
