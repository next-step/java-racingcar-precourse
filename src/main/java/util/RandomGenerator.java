package util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static Boolean isMoreThanFour() {
        int randomNumber = random.nextInt(10);
        return randomNumber >= 4;
    }
}
