package racingcar.model;

import racingcar.validation.CarNamesValidation;

public class CarNames implements CarNamesValidation {

    private final String carNames;

    public CarNames(String carNames) {
        this.carNames = carNames(carNames);
    }

    public String carNames() {
        return this.carNames;
    }

    private String carNames(String carNames) {
        return validCarNames(carNames);
    }
}
