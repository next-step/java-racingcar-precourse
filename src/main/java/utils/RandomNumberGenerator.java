package utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int create() {
        return this.random.nextInt(10);
    }
}
