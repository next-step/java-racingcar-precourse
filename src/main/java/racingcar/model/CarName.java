package racingcar.model;

import static racingcar.utils.Constants.CAR_NAME_MAX_LENGTH;

import racingcar.utils.Constants;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if(carName.isEmpty() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX+Constants.ERROR_ILLEGAL_CAR_NAME);
        }
    }

    public String getCarName() {
        return this.carName;
    }
}
