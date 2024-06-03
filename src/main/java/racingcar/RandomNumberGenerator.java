package racingcar;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    // 0에서 9 사이에서 무작위 값
    public static int generate() {
        return random.nextInt(10);
    }
}