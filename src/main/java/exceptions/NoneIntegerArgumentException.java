package exceptions;

import advice.ErrorMessage;

public class NoneIntegerArgumentException extends IllegalArgumentException {

    public NoneIntegerArgumentException() {
        super(ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER.getMessage());
    }
}
