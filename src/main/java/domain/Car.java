package domain;

import constant.CarRule;
import constant.ExceptionMessage;

public class Car {
    private String name;
    private Distance location = Distance.zeroDistance();

    public void move() {
        location.add(CarRule.MOVING_DISTANCE_PER_MOVE);
    }

    public Distance getLocation() {
        return location;
    }

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > CarRule.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_LIMIT_EXCEPTION);
        }
    }
}
