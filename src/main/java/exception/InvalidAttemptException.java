package exception;

public class InvalidAttemptException extends NumberFormatException{

    public InvalidAttemptException() {
        super(ErrorMessage.ATTEMPT_NOT_INTEGER.getMessage());
    }
}
