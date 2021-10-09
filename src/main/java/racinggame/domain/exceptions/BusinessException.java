package racinggame.domain.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }
}
