package domain;

public class Car {
    public static final int START_POSITION = 0;
    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public int moveForward() {
        return ++position;
    }

    public int stop() {
        return 0;
    }
}
