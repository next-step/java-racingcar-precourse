package util;

import java.util.Random;

public class Utils {

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(0, 10);
    }

}
