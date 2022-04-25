package racingcar.exception;

import racingcar.model.CarName;
import racingcar.model.Round;

public class IllegalArgumentException extends RuntimeException {
    public static final IllegalArgumentException OVER_THE_MAX_LENGTH_CAR_NAME = new IllegalArgumentException(CarName.MAX_LENGTH_CAR_NAME_ERROR_MSG);
    public static final IllegalArgumentException LESS_THAN_MIN_LENGTH_CAR_NAME = new IllegalArgumentException(CarName.MIN_LENGTH_CAR_NAME_ERROR_MSG);
    public static final IllegalArgumentException NOT_NUMBER_ROUND = new IllegalArgumentException(Round.NOT_NUMBER_ERROR_MSG);
    public static final IllegalArgumentException LESS_THAN_MIN_NUMBER_ROUND = new IllegalArgumentException(Round.MIN_ROUND_NUMER_ERROR_MSG);

    public IllegalArgumentException(final String errorMessage) {super(errorMessage);}
}
