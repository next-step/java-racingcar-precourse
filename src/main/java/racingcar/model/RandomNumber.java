package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private int number;

    public RandomNumber() {
        this.number = 0;
    }

    public int next() {
        this.number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return this.number;
    }
}
