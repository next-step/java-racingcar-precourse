package racingCar.CustomException;

public class TooLongNameException extends IllegalArgumentException implements CustomException{

    public TooLongNameException() {}

    public TooLongNameException(String message) {
        super(message);
    }
}
