package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class InvalidRaceCountFormatException extends RuntimeException {
    public InvalidRaceCountFormatException() {
        super(ErrorMessage.INVALID_RACE_COUNT_FORMAT);
    }

    public InvalidRaceCountFormatException(String message) {
        super(message);
    }
}
