package utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(9);
    }
}
