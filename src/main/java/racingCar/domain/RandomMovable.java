package racingCar.domain;

import java.util.Random;

public class RandomMovable implements MovableStrategy {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;

    private RandomNumber randomNumber;

    public void createRandomNumber() {
        Random random = new Random();
        this.randomNumber = new RandomNumber(random.nextInt(RANDOM_NUMBER_BOUNDARY));
    }

    @Override
    public boolean movable() {
        createRandomNumber();
        return this.randomNumber.isMovable();
    }

}
