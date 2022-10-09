package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class InvalidRaceCountRangeException extends RuntimeException {
    public InvalidRaceCountRangeException() {
        super(ErrorMessage.INVALID_RACE_COUNT_RANGE);
    }

    public InvalidRaceCountRangeException(String message) {
        super(message);
    }
}
