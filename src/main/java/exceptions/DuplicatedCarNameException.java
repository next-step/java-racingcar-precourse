package exceptions;

import advice.ErrorMessage;

public class DuplicatedCarNameException extends IllegalArgumentException {
    public DuplicatedCarNameException() {
        super(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
    }
}
