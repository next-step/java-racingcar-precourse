package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
