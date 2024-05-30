package util;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();
    private static final int ORIGIN = 0;
    private static final int BOUND = 10;

    public static int createRandomNumber() {
        return random.nextInt(ORIGIN,BOUND);
    }
}
