package racinggame.exception;

public class RaceGameException extends RuntimeException {

    public RaceGameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
