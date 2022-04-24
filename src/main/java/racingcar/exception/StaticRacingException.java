package racingcar.exception;

import static racingcar.exception.RacingExceptionType.*;

public class StaticRacingException {
    public static final RacingException INVALID_RACING_NAME_NOT_NULL_EXCEPTION;
    public static final RacingException INVALID_RACING_NAME_LENGTH_EXCEPTION;
    public static final RacingException INVALID_MOVE_RANGE_EXCEPTION;
    public static final RacingException INVALID_ROUND_NOT_NUMBER_EXCEPTION;
    public static final RacingException INVALID_ROUND_LESS_THEN_ZERO_EXCEPTION;

    static {
        INVALID_RACING_NAME_NOT_NULL_EXCEPTION = new RacingException(INVALID_RACING_NAME_NOT_NULL);
        INVALID_RACING_NAME_LENGTH_EXCEPTION = new RacingException(INVALID_RACING_NAME_LENGTH);
        INVALID_MOVE_RANGE_EXCEPTION = new RacingException(INVALID_MOVE_RANGE);
        INVALID_ROUND_NOT_NUMBER_EXCEPTION = new RacingException(INVALID_ROUND_NOT_NUMBER);
        INVALID_ROUND_LESS_THEN_ZERO_EXCEPTION = new RacingException(INVALID_ROUND_LESS_THEN_ZERO);
    }
}
