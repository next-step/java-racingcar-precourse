package racingcar.domain;

public class Car {
    public static final int CAR_POSITION_INCREASE_UNIT = 1;

    private CarName carName;
    private CarPosition carPosition;

    private Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car create(CarName carName) {
        return new Car(carName, CarPosition.init());
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    public void moveByAccelPower(AccelPower accelPower) {
        if (accelPower.isPossibleMove()) {
            this.carPosition.increase(CAR_POSITION_INCREASE_UNIT);
        }

    }
}
