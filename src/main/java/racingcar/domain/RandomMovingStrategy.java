package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    @Override
    public boolean movable() {
        return getRandomNumber() >= Constant.FORWARD_CONDITION;
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }
}
