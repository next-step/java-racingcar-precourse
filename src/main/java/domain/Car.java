package domain;

public class Car {
    public static final Distance MOVING_DISTANCE = new Distance(1);
    private String name;
    private Distance location = Distance.zeroDistance();

    public void move() {
        location.add(MOVING_DISTANCE);
    }

    public Distance getLocation() {
        return location;
    }

    public Car(String name) {
        this.name = name;
    }
}
