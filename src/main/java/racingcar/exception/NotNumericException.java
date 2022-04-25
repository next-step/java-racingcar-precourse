package racingcar.exception;

public class NotNumericException extends IllegalArgumentException implements MessageException {

    private static final String ERROR_MESSAGE = "Game Count must need numeric input.";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
