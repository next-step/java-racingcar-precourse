package utils;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    public static int generate() {
        return RANDOM.nextInt(MAX_RANDOM_VALUE);
    }
}
