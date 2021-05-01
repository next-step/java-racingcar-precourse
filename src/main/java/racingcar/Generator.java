package racingcar;

import java.util.Random;

public class Generator {

    private Generator() {}

    public static int randomNumber() {

        return new Random().nextInt(9) + 1;
    }
}
