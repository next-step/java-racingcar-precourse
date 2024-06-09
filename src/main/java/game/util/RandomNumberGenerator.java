package game.util;

import java.util.Random;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    /**
     * 파라미터로 전달받은 범위 안에서 무작위 음이 아닌 정수를 반환합니다.
     * @param maxRange 난수의 최댓값
     * @return 음이 아닌 정수
     */
    public static int getNumber(int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange + 1);
    }

}
