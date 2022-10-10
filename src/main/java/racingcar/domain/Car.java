package racingcar.domain;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    String getCarName() {
        return carName.getName();
    }

    int getCarPosition() {
        return carPosition.getPosition();
    }

    public void control(ControlType controlType) {
        carPosition.control(controlType);
    }

    public boolean isAheadPosition(Winners winners) {
        return this.getCarPosition() > winners.getPosition();
    }

    public boolean isBehindPosition(Winners winners) {
        return this.getCarPosition() < winners.getPosition();
    }
}
