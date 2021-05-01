package domain;

public class Car {

    private Name carName;

    public Car(String carName) {
        this.carName = new Name(carName);
    }

    public Car() {

    }

    public Name getCarName() {
        return carName;
    }
}
