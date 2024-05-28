package racingCar.customException;

public class TooLongNameException extends IllegalArgumentException implements CustomException{

    public TooLongNameException() {}

    public TooLongNameException(String message) {
        super(message);
    }
}
