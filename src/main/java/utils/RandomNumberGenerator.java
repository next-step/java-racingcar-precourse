package utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_RULE = 10;
    private static final Random random = new Random();
    public static int generator(){
        return random.nextInt(RANDOM_NUMBER_RULE);
    }
}
