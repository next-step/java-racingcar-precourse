package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class InvalidCarNameSizeException extends RuntimeException {
    public InvalidCarNameSizeException() {
        super(ErrorMessage.INVALID_CAR_NAME);
    }

    public InvalidCarNameSizeException(String message) {
        super(message);
    }
}
