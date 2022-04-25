package racingcar.exception;

public interface MessageException {

    String getErrorMessage();

    default String getFormattedErrorMessage() {
        return "[ERROR] " + getErrorMessage();
    }
}
