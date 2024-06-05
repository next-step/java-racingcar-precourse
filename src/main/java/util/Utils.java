package util;

import java.util.Random;

public class Utils {
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
