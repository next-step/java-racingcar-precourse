package model;

import java.util.Random;

public class RandomCarMoveRule implements CarMoveRule {

    private static final int MOVE_LOWER_BOUND = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        if (randomNumber >= MOVE_LOWER_BOUND) {
            return true;
        }
        return false;
    }
}