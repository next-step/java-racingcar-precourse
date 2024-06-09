package main.java.racingcar.domain;

public class Car {

    public static final int START_POSITION = 0;
    private final CarName name;
    private final int speed;
    private final Position position;
    public Car(CarName carName) {
        this.name = carName;
        this.speed = 1;
        this.position = new Position(START_POSITION);
    }
}
