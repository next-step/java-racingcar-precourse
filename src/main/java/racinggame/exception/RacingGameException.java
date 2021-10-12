package racinggame.exception;

public class RacingGameException extends RuntimeException {
    private final RacingGameErrorCode errorCode;

    public RacingGameException(String message, RacingGameErrorCode errorCode) {
        super(errorCode.getMessage() + " " + message);
        this.errorCode = errorCode;
    }

    public RacingGameException(RacingGameErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
