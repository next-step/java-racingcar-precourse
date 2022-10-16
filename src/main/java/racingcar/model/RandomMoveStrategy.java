package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MovingStrategy{
    private final int FORWARD_CONDITION = 4;

    @Override
    public boolean isMovable() {
        if(getRandomNumber() >= FORWARD_CONDITION) return true;
        return false;
    }
    protected int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
