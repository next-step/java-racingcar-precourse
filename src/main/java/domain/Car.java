package domain;

public class Car {

    private int distance;
    private Name carName;
    private static final int MOVABLE_NUMBER = 4;

    public Car(Name carName) {
        this(0, carName);
    }

    public Car(int distance, Name carName) {
        this.distance = distance;
        this.carName = carName;
    }

    public int distance() {
        return this.distance;
    }

    public String carName() {
        return this.carName.name();
    }

    public Car move() {
        return new Car(this.distance + 1, this.carName);
    }

    public boolean isMovable(int number) {
        return number > MOVABLE_NUMBER;
    }


}
