package model;

import utils.Constants;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Constants.MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(position);
    }
}
