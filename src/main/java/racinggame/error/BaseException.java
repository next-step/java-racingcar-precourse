package racinggame.error;

import static racinggame.type.StringConstants.ERROR_TAG;

public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(ERROR_TAG + message);
    }
}
