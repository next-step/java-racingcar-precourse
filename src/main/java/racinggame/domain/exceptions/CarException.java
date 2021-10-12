package racinggame.domain.exceptions;

import java.util.NoSuchElementException;

public class CarException extends NoSuchElementException {

    public CarException(String errorMsg){
        super(errorMsg);
    }
}
