package racingcar.model.vo;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RandomRules;

public class RandomNumber {

    private final int moveNumber;

    public RandomNumber() {
        this.moveNumber = makeRandomNumber();
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RandomRules.minCondition(), RandomRules.maxCondition());
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}
