package racingcar;

import java.util.Random;

public class Forward {
    Random random = new Random();

    public boolean isForwardCondition() {
        return random.nextInt(9)>= 4;
    }

}
