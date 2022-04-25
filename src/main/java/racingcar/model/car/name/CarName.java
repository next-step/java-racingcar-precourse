package racingcar.model.car.name;

import racingcar.error.Error;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private final String carName;

    public CarName(String carName) {
        validationCheck(carName);
        this.carName = carName;
    }

    private void validationCheck(String carName) {
        if (isNull(carName) || isOutOfRange(carName)) {
            throw new IllegalArgumentException(Error.NOT_VALID_CAR_NAME.message());
        }
    }

    private boolean isNull(String carName) {
        return carName == null;
    }

    private boolean isOutOfRange(String carName) {
        return carName.length() > MAX_LENGTH || carName.length() < MIN_LENGTH;
    }

    public String name() {
        return this.carName;
    }
}
