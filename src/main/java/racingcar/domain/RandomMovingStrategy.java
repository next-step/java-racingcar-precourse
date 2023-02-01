package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements GameMovingStrategy{
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        return getRandomNum() >= FORWARD_NUM;
    }

    private int getRandomNum(){
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
