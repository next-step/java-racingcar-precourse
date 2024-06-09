package Utils;

import java.util.Random;

public class RandomUtil {

    public static int[] getRandomArray(int length, int min, int max) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }
}
