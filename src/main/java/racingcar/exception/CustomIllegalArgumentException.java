package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException() {
    }

    public CustomIllegalArgumentException(String message) {
        super(ErrorMessage.PREFIX.getValue() + message);
    }
}

