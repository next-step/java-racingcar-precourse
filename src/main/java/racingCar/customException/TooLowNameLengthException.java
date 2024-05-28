package racingCar.customException;

public class TooLowNameLengthException extends IllegalArgumentException implements CustomException {
    public TooLowNameLengthException() {}
    public TooLowNameLengthException(String message) {
        super(message);
    }
}
