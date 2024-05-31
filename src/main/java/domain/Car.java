package domain;

import util.RandomNumberGenerator;

public class Car {
    private static final int THRESHOLD = 4;
    private CarName carName;
    private int moved;

    public Car(CarName carName) {
        this.carName = carName;
        this.moved = 0;
    }

    public String carName() {
        return carName.getValue();
    }
}
