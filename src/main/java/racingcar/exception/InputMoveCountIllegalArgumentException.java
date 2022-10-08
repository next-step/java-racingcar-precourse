package racingcar.exception;

import static racingcar.utils.RacingCarConstants.COMMON_ERROR_MESSAGE;

public class InputMoveCountIllegalArgumentException extends IllegalArgumentException {
    public InputMoveCountIllegalArgumentException(String msg) {
        super(COMMON_ERROR_MESSAGE + msg);
    }
}
