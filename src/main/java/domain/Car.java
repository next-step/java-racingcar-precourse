package domain;

public class Car {

    private final Name carName;

    private final Distance carDistance;

    public Car(String carName) {
        this.carName = new Name(carName);
        this.carDistance = new Distance(0);
    }

    public Name getCarName() {
        return carName;
    }

    public Distance getCarDistance() {
        return carDistance;
    }

    public void moveCar(){
        carDistance.move();
    }
}
