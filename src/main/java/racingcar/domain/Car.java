package racingcar.domain;

public class Car {
    public static final int MOVE_MIN_NUMBER = 4;
    public static final int MOVE_DISTANCE = 1;

    private final CarName name;
    private final Position position;

    public Car(String name) {

        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_MIN_NUMBER) {
            this.position.plus(MOVE_DISTANCE);
        }
    }

    public CarName name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }
}
