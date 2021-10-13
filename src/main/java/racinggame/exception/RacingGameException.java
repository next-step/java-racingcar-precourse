package racinggame.exception;

public class RacingGameException extends RuntimeException {
    public RacingGameException(RacingGameErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
