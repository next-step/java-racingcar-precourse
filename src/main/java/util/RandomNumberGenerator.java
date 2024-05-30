package util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static int makeRandomNumber() {
        return random.nextInt(9);
    }
}
