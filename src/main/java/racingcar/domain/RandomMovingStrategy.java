package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;
    private static final int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD_NUM;
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
