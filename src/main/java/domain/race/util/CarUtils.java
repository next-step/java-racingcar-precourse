package domain.race.util;

import java.util.Random;

public abstract class CarUtils {
    static Random random = new Random();

    private CarUtils() {
    }

    // 랜덤 값을 주어 0~3까지는 전진하지 않고, 4이상부터 전진할 수 있도록 하는 함수
    public static boolean canMove() {
        int randInt = random.nextInt(10);
        if (randInt >= 4) return true;
        return false;
    }

}
