package util;

import java.util.Random;

public class RandomUtil {
    private static final int RANGE = 9;

    public static int getRandom(){
        Random rand = new Random();
        return rand.nextInt(RANGE) + 1;
    }
}
