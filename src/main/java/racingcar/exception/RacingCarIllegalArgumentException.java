package racingcar.exception;

public class RacingCarIllegalArgumentException extends RuntimeException {

    private static final String ERROR_TITLE_TEXT = "[ERROR] ";

    public RacingCarIllegalArgumentException(String message) {
        throw new IllegalArgumentException(ERROR_TITLE_TEXT + message);
    }
}
