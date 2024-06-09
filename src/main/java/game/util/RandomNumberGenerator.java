package game.util;

import java.util.Random;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    /**
     * 파라미터로 전달받은 범위 안에서 무작위 양의 정수를 반환합니다.
     * @param maxRange 최대값
     * @return 양의 정수
     */
    public static int getNumber(int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange + 1);
    }

}
