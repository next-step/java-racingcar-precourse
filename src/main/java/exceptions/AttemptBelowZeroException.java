package exceptions;

import advice.ErrorMessage;

public class AttemptBelowZeroException extends IllegalArgumentException {

    public AttemptBelowZeroException() {
        super(ErrorMessage.ATTEMPT_COUNT_MUST_BE_AT_LEAST_ONE.getMessage());
    }
}
