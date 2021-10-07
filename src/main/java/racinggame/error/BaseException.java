package racinggame.error;

public class BaseException extends RuntimeException {

    private static final String ERROR_TAG = "[ERROR]";

    public BaseException(String message) {
        super(ERROR_TAG + message);
    }
}
