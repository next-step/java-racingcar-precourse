package racingCar.customException;

public class TooLowAttemptException extends IllegalArgumentException implements CustomException {
    public TooLowAttemptException() {}
    public TooLowAttemptException(String message) {
        super(message);
    }
}
