package racingcar.exception;

public class RacingGameIllegalArgumentException extends IllegalArgumentException {

    private static final String PREFIX = "[ERROR] ";

    public RacingGameIllegalArgumentException(String message) {
        super(PREFIX + message);
    }


}
