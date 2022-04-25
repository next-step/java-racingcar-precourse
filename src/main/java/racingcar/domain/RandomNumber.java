package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Constant;

public class RandomNumber {

    private final int randomNumber;

    public RandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean canMove(int randomNumber){
        return randomNumber >= Constant.STANDARD_OF_MOVE_FORWARD;
    }

}
