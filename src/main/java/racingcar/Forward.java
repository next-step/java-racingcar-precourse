package racingcar;

import java.util.Random;

import racingcar.Constant;
public class Forward {
    Random random = new Random();

    public boolean isForwardCondition() {
        return random.nextInt(Constant.CONDITION_MAX)>= Constant.CONDITION_MIN;
    }

}
