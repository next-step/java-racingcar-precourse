package racingcar.domain.util;

import java.util.Random;

public class RandomIntegerProvider {

    private static final Random rand = new Random();

    public static int provideRandomNumber(int minNumber, int maxNumber) {
        if (minNumber > maxNumber) {
            throw new IllegalArgumentException("최소값은 최대값보다 클 수 없습니다.");
        }
        int randomNumber = rand.nextInt(minNumber + maxNumber + 1) - minNumber;
        if (randomNumber < minNumber) {
            randomNumber = minNumber;
        }
        return randomNumber;
    }
}