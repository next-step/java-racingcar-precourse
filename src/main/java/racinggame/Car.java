package racinggame;

public class Car {
    private static final int MIN_GAS_POINT_FOR_MOVING_FORWARD = 4;
    private int position;

    public void move(int gasPoint) {
        if (canMove(gasPoint)) {
            moveForward();
        }
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
