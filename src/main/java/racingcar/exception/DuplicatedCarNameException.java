package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class DuplicatedCarNameException extends RuntimeException {
    public DuplicatedCarNameException() {
        super(ErrorMessage.DUPLICATED_CAR_NAME);
    }

    public DuplicatedCarNameException(String message) {
        super(message);
    }
}
