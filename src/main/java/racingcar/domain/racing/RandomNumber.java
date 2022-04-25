package racingcar.domain.racing;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final static int MIN_NUMBER = 0;
    private final static int MAX_NUMBER = 9;
    private final int randomNumber;

    public RandomNumber(int randomNumbers) {
        this.randomNumber = randomNumbers;
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
