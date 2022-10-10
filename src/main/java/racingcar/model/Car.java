package racingcar.model;

import racingcar.function.GameRandomNumberProvider;

public class Car {
    private final CarName carName;
    private Drive drive = new Drive(new GameRandomNumberProvider());
    private final CarPosition carPosition = new CarPosition();

    public Car(CarName carName) {
        this.carName = carName;
    }

    public Car(CarName carName, Drive drive) {
        this.carName = carName;
        this.drive = drive;
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public void drive() {
        this.carPosition.movePosition(drive.move());
    }

    public int getPosition() {
        return this.carPosition.getPosition();
    }
}
