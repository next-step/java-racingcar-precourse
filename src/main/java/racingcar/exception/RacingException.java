package racingcar.exception;

public class RacingException extends RuntimeException {
    public RacingException(final RacingExceptionType racerException) {
        super(racerException.getMessage());
    }
}
