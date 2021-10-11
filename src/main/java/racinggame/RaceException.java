package racinggame;

public class RaceException extends RuntimeException{

    public RaceException(RaceErrorCode errorCode) {
        super(errorCode.message());
    }
}
