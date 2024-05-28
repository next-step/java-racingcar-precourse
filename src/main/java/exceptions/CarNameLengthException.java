package exceptions;

import advice.ErrorMessage;

public class CarNameLengthException extends IllegalArgumentException {

    public CarNameLengthException() {
        super(ErrorMessage.CAR_NAME_OUT_OF_RANGE.getMessage());
    }
}
