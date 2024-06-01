package racingcar;

import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;
    private final Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    protected boolean canMove() {
        return random.nextInt(10) >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}