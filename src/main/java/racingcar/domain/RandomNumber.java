package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int LESS_THAN_NUMBER = 10;

    private final int number;

    public RandomNumber() {
        this.number = new Random().nextInt(LESS_THAN_NUMBER);
    }

    public int getNumber() {
        return this.number;
    }
}
