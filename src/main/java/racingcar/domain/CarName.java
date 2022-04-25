package racingcar.domain;

import racingcar.message.ErrorMessage;
import racingcar.util.ValidationUtils;

public class CarName {

    private static final int CAR_NAME_LENGTH_MIN = 1;
    private static final int CAR_NAME_LENGTH_MAX = 5;

    private final String carName;

    public CarName(String carName) {
        validCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validCarName(String carName) {
        if (!ValidationUtils
                .validNumberOfLetter(carName, CAR_NAME_LENGTH_MIN, CAR_NAME_LENGTH_MAX)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ERROR.getMessage());
        }
    }
}
