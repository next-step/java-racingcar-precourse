package domain;

import java.util.Random;

public class Rule {
    private static final Random random = new Random();
    private static final int FORWARD_STANDARD_NUMBER = 4;
    private static final int RANDOM_STANDARD_NUMBER = 10;

    public static boolean isforward() {
        int randomNumber = random.nextInt(RANDOM_STANDARD_NUMBER);
        return randomNumber >= FORWARD_STANDARD_NUMBER;
    }

}
