package util;

import java.util.Random;

public class DefaultRandomNumberGenerator implements IRandomNumberGenerator {
    private static final Random random = new Random();

    /**
     * 0 ~ 9 사이의 랜덤 정수를 반환하는 메서드
     *
     * @return 0 ~ 9 사이의 랜덤 정수
     */
    public int generate() {
        return random.nextInt(10);
    }
}
