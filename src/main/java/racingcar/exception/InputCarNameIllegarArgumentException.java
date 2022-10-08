package racingcar.exception;

import static racingcar.utils.RacingCarConstants.COMMON_ERROR_MESSAGE;

public class InputCarNameIllegarArgumentException extends IllegalArgumentException {
    public InputCarNameIllegarArgumentException(String msg) {
        super(COMMON_ERROR_MESSAGE + msg);
    }
}
