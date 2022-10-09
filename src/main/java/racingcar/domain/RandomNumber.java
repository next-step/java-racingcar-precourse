package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

    private final int randomNumber;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    public RandomNumber() {
        this.randomNumber = pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public RacingNumber convertRandomNumber() {
        return new RacingNumber(randomNumber);
    }
}
