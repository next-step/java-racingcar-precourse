package domainTest.exceptions;

public class CarException extends IllegalArgumentException {

    public CarException(String errorMsg){
        super(errorMsg);
    }
}
