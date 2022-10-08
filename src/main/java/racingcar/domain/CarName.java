package racingcar.domain;

import racingcar.exception.InputCarNameIllegarArgumentException;

import static racingcar.utils.RacingCarConstants.CAR_NAME_MAX_LENGTH;
import static racingcar.utils.RacingCarConstants.MSG_CAR_NAME_LENGTH_EXCEPTION;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new InputCarNameIllegarArgumentException(MSG_CAR_NAME_LENGTH_EXCEPTION);
        }
    }
}
