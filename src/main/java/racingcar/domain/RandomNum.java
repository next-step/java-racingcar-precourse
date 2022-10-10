package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private int randomNum;

    public RandomNum() {
        this.randomNum = makeRandomNum();
    }

    private int makeRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public int getRandomNum() {
        return this.randomNum;
    }
}
