package model;

import java.util.Random;

public class RandomMaker {
    Random random = new Random();

    /**
     * 랜덤한 값을 생성합니다.
     * @return 0 <= return <= 9
     */
    public int getRandomValue() {
        return random.nextInt(0,10);
    }
}
