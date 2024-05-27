package domain.car;

import java.util.Random;

public abstract class CarUtils {
    static Random random = new Random();

    private CarUtils() {
    }

    public static boolean canMove() {
        int randInt = random.nextInt(10);
        if (randInt >= 4) return true;
        return false;
    }

}
