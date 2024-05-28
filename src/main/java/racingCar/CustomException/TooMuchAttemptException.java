package racingCar.CustomException;

public class TooMuchAttemptException extends IllegalArgumentException implements CustomException{
    public TooMuchAttemptException() {}
    public TooMuchAttemptException(String message) {
        super(message);
    }
}
