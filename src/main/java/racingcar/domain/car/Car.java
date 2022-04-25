package racingcar.domain.car;

public class Car {
    private static final int START_POSITION = 0;
    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(START_POSITION);
    }

    public CarName getCarName() {
        return name;
    }

    public CarPosition getCarPosition() {
        return position;
    }

    public void moveForward() {
        position.move();
    }
}
