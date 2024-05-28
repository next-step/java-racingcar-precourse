package exceptions;

import advice.ErrorMessage;

public class CarCountLessThenTwoException extends IllegalArgumentException {

    public CarCountLessThenTwoException() {
        super(ErrorMessage.CAR_COUNT_LESS_THAN_TWO.getMessage());
    }
}
