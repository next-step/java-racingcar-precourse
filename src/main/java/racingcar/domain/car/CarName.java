package racingcar.domain.car;

import static racingcar.domain.ErrorMessage.CAR_NAME_SIZE;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    public static CarName createCarName(String carName) {
        validCarName(carName);
        return new CarName(carName);
    }

    private static void validCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_SIZE);
        }
    }

    public String getCarName() {
        return carName;
    }

    public boolean isEquals(CarName carNameTarget) {
        return carName.equals(carNameTarget.getCarName());
    }
}
