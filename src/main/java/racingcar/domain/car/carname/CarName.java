package racingcar.domain.car.carname;

import racingcar.domain.car.carname.validation.CarNameValidator;

public class CarName {

    private String carName;
    private CarNameValidator validator;

    public CarName(String carName, CarNameValidator validator) {
        this.carName = carName;
        this.validator = validator;
        validator.validate(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
