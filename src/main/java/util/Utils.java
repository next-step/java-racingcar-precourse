package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {
    private static final Random random = new Random();
    public static int generateRandomNumber() {
        return random.nextInt(10);
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
