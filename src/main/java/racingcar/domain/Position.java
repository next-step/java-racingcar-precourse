package racingcar.domain;

public class Position {

    private static final int INIT_VALUE = 0;
    private static final int MOVE_NUMBER = 1;

    private int value;

    public Position() {
        this.value = INIT_VALUE;
    }

    public void moveForward() {
        this.value += MOVE_NUMBER;
    }

    public int getValue() {
        return value;
    }
}
