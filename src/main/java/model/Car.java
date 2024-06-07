package model;

public class Car {

    private final CarName carName;
    private int position;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }
}
