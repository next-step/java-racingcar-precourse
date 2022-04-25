package racingcar.exception;

public class InvalidUserCountException extends IllegalArgumentException implements MessageException {

    private static final String ERROR_MESSAGE = "Invalid User Count.";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
