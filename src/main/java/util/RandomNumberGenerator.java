package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    public static int generate(int start, int end) {
        return RANDOM.nextInt(end - start + 1) + start;
    }
}