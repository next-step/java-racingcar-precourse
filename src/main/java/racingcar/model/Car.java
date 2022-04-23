package racingcar.model;

import racingcar.common.type.CarName;
import racingcar.common.type.CarPosition;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition = new CarPosition();

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public String getCarName() {
        return this.carName.toString();
    }

    public void moveForwardRandom() {
        this.carPosition.moveForwardRandom();
    }

    public int getCarPosition() {
        return this.carPosition.getCarPosition();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.carName, this.carPosition);
    }
}
