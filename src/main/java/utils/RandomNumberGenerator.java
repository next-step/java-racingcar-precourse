package utils;

import java.util.Random;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {

    }

    public static RandomNumberGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int getRandomNumber(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        return LazyHolder.random.nextInt((end - start) + 1) + start;
    }

    private static class LazyHolder {
        private static final Random random = new Random();
        private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();
    }
}
