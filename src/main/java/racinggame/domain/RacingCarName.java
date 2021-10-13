package racinggame.domain;

import java.util.NoSuchElementException;

import static racinggame.domain.GameConfig.RACING_CAR_NAME_MAX_LENGTH;
import static racinggame.domain.GameConfig.RACING_CAR_NAME_MIN_LENGTH;
import static racinggame.domain.GameErrorMessage.ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE;

public class RacingCarName {
    private final String racingCarName;

    public RacingCarName(final String racingCarName) {
        validateRacingCarName(racingCarName);
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public void validateRacingCarName(final String racingCarName) {
        isValidRacingCarNameLengthLimit(racingCarName);
    }

    public void isValidRacingCarNameLengthLimit(final String racingCarName) {
        int length = racingCarName.length();
        if (length < RACING_CAR_NAME_MIN_LENGTH.getValue() || length > RACING_CAR_NAME_MAX_LENGTH.getValue()) {
            System.out.println(ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE.getErrorMessage());
            throw new NoSuchElementException(ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE.getErrorMessage());
        }
    }
}
