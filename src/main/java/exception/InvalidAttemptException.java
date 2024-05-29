package exception;

public class InvalidAttemptException extends IllegalArgumentException{

    public InvalidAttemptException() {
        super(ErrorMessage.ATTEMPT_NOT_INTEGER.getMessage());
    }
}
