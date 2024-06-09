package util;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generateRandNum() {
        Random random = new Random();
        return  random.nextInt(9) + 1;
    }
}
