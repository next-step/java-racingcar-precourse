package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MOVE_CRITERIA = 4;

    @Override
    public boolean isMove() {
        return RandomNumberGenerator.getRandomNumber() >= MOVE_CRITERIA;
    }
}
