package racingcar.model;

import racingcar.validation.CarNameValidation;

public class CarName implements CarNameValidation {

    private final String carName;

    public CarName(String carName) {
        this.carName = validName(carName.trim());
    }

    public String carName() {
        return carName;
    }
}
