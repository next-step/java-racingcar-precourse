package exception;

public class AttemptSizeException extends IllegalArgumentException{

    public AttemptSizeException() {
        super(ErrorMessage.ATTEMPT_LESS_THAN_ONE.getMessage());
    }
}
