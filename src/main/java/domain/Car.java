package domain;

import constant.CarRule;
import constant.ExceptionMessage;
import dto.CarDto;

public class Car {
    private String name;
    private Distance location = Distance.zeroDistance();

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > CarRule.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_LIMIT_EXCEPTION);
        }
    }

    public void move() {
        location.add(CarRule.MOVING_DISTANCE_PER_MOVE);
    }

    public CarDto toDto() {
        return new CarDto(this.name, this.location.getValue());
    }


}
