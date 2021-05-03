package utils;

import java.util.Random;

public class NumberUtil {
    private final Random random;

    public NumberUtil() {
        this.random = new Random();
    }

    public int createBetweenZeroToNine() {
        return this.random.nextInt(10);
    }
}
