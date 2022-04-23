package racingcar.domain.strategy;

import racingcar.domain.RandomNumber;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private final RandomNumber randomNumber;

    private static final int MOVABLE_STANDARD_VALUE = 4;

    public RandomNumberMoveStrategy() {
        this.randomNumber = new RandomNumber();
    }

    @Override
    public boolean isMovable() {
        return randomNumber.getRandomNumber() >= MOVABLE_STANDARD_VALUE;
    }
}
