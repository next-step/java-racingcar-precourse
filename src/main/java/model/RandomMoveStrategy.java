package model;

import java.util.Random;

public class RandomMoveStrategy {
    private static final int MOVE_THRESHOLD = 4;

    public boolean isMovable() {
        return new Random().nextInt(10) >= MOVE_THRESHOLD;
    }
}
