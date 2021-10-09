package racinggame.model;

import racinggame.exception.ValidationException;

public class Car {
    private final String carName;
    private int distance;
    private static final int MOVING_MIN_COUNT = 3;
    private static final int DISTANCE = 1;

    public Car(String carName) {
        if (!validateName(carName)) {
            throw new ValidationException();
        }
        this.carName = carName;
    }

    private boolean validateName(String carName) {
        return carName.matches("^[\\w]{1,5}$");
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

}
