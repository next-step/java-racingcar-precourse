package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int generateRandomNumber() {
        return random.nextInt(BOUND);
    }

    public static List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = generateRandomNumber();
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
}
