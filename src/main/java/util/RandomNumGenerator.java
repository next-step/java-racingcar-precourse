package util;

import java.util.Random;

public class RandomNumGenerator implements NumGenerator {

    Random random = new Random();

    @Override
    public int getRandomInt() {
        return random.nextInt(10); //0 <= x <= 9
    }

}
