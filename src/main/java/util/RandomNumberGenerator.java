package util;

import java.util.Random;

public class RandomNumberGenerator {

    private static Random randomGenerator;
    private static final int RANDOM_NUMBER_MAXIMUM = 9;

    private RandomNumberGenerator() {}

    public static Random getInstance() {
        if (randomGenerator == null) {
            randomGenerator = new Random();
        }
        return randomGenerator;
    }

    public static int generateRandomNumber() {
        return getInstance().nextInt(RANDOM_NUMBER_MAXIMUM);
    }
}
