package domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean movable() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }
}
