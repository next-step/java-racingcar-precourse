package racingcar.Exception;

public class RacingIllegalArgumentException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR]";

    public RacingIllegalArgumentException(String msg) {
        super(ERROR_MESSAGE + " " + msg);
    }
}
