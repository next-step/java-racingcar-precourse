package racingcar.domain.car;

import static racingcar.domain.ErrorMessage.MOVE_ONLY_FORWARD;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition createNewCarPosition() {
        return new CarPosition(0);
    }

    public static CarPosition createCarPosition(int position) {
        return new CarPosition(position);
    }

    public void move(int moveDistance) {
        this.validMoveDistance(moveDistance);
        this.position += moveDistance;
    }

    private void validMoveDistance(int moveDistance) {
        if (moveDistance < 0) {
            throw new IllegalStateException(MOVE_ONLY_FORWARD);
        }
    }

    public int getIntPosition() {
        return position;
    }

    public boolean isEquals(CarPosition carPosition) {
        return position == carPosition.getIntPosition();
    }
}
