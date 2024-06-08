package model;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD  = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("올바른 입력형태가 아닙니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(Random random) {
        if (random.nextInt(10) >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}