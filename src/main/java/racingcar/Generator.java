package racingcar;

import java.util.Random;

public class Generator {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private Generator() {}

    public static Number randomNumber() {

        return new Number(new Random().nextInt(MAX_NUMBER) + MIN_NUMBER);
    }
}
