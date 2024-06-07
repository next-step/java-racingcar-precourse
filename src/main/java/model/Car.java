package model;

public class Car {

    private final CarName carName;
    private int position;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public CarState moveOrStay(CarMoveRule carMoveRule) {
        if (carMoveRule.canMove()) {
            position++;
        }
        return new CarState(carName.getCarName(), position);
    }
}
