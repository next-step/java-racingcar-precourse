package racingCar.customException;

public class TooMuchAttemptException extends IllegalArgumentException implements CustomException{
    public TooMuchAttemptException() {}
    public TooMuchAttemptException(String message) {
        super(message);
    }
}
