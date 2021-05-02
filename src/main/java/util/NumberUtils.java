package util;

import java.util.Random;

public class NumberUtils {
    private static final Random random = new Random();

    public static int create(int startNum, int endNum) {

        if (startNum > endNum) {
            throw new IllegalArgumentException();
        }
        if (startNum == endNum) {
            return startNum;
        }
        return startNum + random.nextInt(endNum - startNum + 1);
    }
}
