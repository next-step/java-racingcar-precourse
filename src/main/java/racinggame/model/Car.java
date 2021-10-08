package racinggame.model;

import java.util.List;

public class Car {
    private final String carName;
    private static final int MOVING_MIN_COUNT = 3;
    private static final int DISTANCE = 1;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
