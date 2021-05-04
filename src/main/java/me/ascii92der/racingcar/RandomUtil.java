package me.ascii92der.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int generateRandomNumber() {
        return random.nextInt(BOUND);
    }

}
