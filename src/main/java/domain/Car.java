package domain;

public class Car {

    private Name carName;

    private Distance carDistance;

    public Car(String carName) {
        this.carName = new Name(carName);
        this.carDistance = new Distance(0);
    }

    public Car() {

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
