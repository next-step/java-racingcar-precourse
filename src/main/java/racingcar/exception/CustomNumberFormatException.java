package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException() {
    }

    public CustomNumberFormatException(String message) {
        super(ErrorMessage.PREFIX.getValue() + message);
    }
}
