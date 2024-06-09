package util;

import java.util.Random;

public class RandomGeneratingMove implements RandomGenerator {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private Random random;

    public RandomGeneratingMove() {
        this.random = new Random();
    }

    @Override
    public int generateRandomInt() {
        return random.nextInt((MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1)) + MIN_RANDOM_NUMBER;
    }
}

