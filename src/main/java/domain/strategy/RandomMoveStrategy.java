package domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int RANDOM_BIGGER_THAN = 4;

    @Override
    public boolean movable() {
        Random random = new Random();

        return random.nextInt(MAX_RANDOM_NUMBER) >= RANDOM_BIGGER_THAN;
    }
}
