package racingcar.model;

import java.util.Objects;
import racingcar.utils.Constants;

public class Car {
    private final CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public void moveCarPosition(Integer randomNumber) {
        if(randomNumber >= Constants.CAR_MOVING_CONDITION) {
            this.carPosition = new CarPosition(this.getCarPosition() + Constants.CAR_MOVING_AMOUNT);
        }
    }

    public Car comparePosition(CarPosition carPosition) {
        if(Objects.equals(this.carPosition.getCarPosition(), carPosition.getCarPosition())) {
            return this;
        }

        return null;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Integer getCarPosition() {
        return carPosition.getCarPosition();
    }
}