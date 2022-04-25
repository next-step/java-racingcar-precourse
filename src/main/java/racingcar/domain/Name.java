package racingcar.domain;

import racingcar.common.Constant;
import racingcar.common.ErrorMessage;

public class Name {
    private final String carName;

    public Name(String carName) {
        nameValidation(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void nameValidation(String carName) {
        if (isEmptyName(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_CARS_NAME);
        }
        if (isExceedNameLength(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MAX_CAR_NAME_LENGTH);
        }
    }

    private boolean isEmptyName(String carName) {
        return carName == null || carName.length() == 0;
    }

    private boolean isExceedNameLength(String carName) {
        return carName.length() > Constant.MAX_CAR_NAME_LENGTH;
    }
}
