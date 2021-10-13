package racinggame.domain;

public class Car {
    private static final int MIN_GAS_POINT_FOR_MOVING_FORWARD = 4;
    private final CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
    }

    public Record move(int gasPoint) {
        if (canMove(gasPoint)) {
            moveForward();
        }
        return new Record(name, position);
    }

    private void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean canMove(int gasPoint) {
        return gasPoint >= MIN_GAS_POINT_FOR_MOVING_FORWARD;
    }
}
