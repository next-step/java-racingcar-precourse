package racinggame.domain;

public class NotExistWinnerException extends RuntimeException {
    public NotExistWinnerException() {
        super();
    }

    public NotExistWinnerException(String message) {
        super(message);
    }

    public NotExistWinnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistWinnerException(Throwable cause) {
        super(cause);
    }
}
