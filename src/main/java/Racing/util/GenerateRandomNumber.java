package Racing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumber {

    public static final int MAX_NUMBER = 9;

    Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }


}