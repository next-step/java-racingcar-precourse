package racingcar.model.car;

public class Position {

    private static final int MOVING_COUNT = 1;
    private static final int IDLE_COUNT = 0;
    private int position;

    public Position(boolean canGoForward) {
        position = calculateCount(canGoForward);
    }

    private int calculateCount(boolean canGoForward) {
        if (canGoForward) {
            return MOVING_COUNT;
        }
        return IDLE_COUNT;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMove() {
        if (this.position == MOVING_COUNT) {
            return true;
        }
        return false;
    }

}
