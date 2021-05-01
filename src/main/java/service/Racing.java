package service;

import domain.Cars;

public class Racing {

    private Cars cars;

    public int getCarNameLength(String carName) {
        return carName.length();
    }

    public Cars getDeviceValue(String carNames) {
        return new Cars(carNames);
    }

    public Racing(String carNames) {
        this.cars =  getDeviceValue(carNames);
    }

    public Cars getCars() {
        return cars;
    }
}
