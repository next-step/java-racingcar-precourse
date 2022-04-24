package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomService {

    public static final int RANDOM_MIN_NUMBER = 1;
    public static final int RANDOM_MAX_NUMBER = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }

}
