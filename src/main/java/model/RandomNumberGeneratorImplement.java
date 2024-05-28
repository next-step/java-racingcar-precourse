package model;

import java.util.Random;

public class RandomNumberGeneratorImplement implements RandomNumberGenerator {

    private final Random random;

    public RandomNumberGeneratorImplement() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        // 0 이상 9 이하의 랜덤 정수 생성
        return random.nextInt(10);
    }
}
