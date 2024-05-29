package race.model;

import java.util.Random;

public class CustomRandom extends Random {
    private CustomRandom() {}

    private static final class SingleTonHelper {
        private static final CustomRandom INSTANCE = new CustomRandom();
    }

    public static CustomRandom getInstance() {
        return SingleTonHelper.INSTANCE;
    }

    public boolean canMove() {
        return nextInt(10) >= 4;
    }
}
