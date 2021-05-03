package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final String INVALID_MESSAGE = "0~9 사이 숫자를 입력해 주세요.";
    private static final Random random = new Random();

    private final int number;

    public RandomNumber() {
        this.number = random.nextInt(MAX_NUMBER + 1);
    }

    public RandomNumber(int number) {
        if (MIN_NUMBER > number || MAX_NUMBER < number) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
