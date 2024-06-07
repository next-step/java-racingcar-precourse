package race.model;

import java.util.Random;

public class CustomRandom extends Random {
    public boolean canMove() {
        return nextInt(10) >= 4;
    }
}
