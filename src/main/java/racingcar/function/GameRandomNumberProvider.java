package racingcar.function;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRandomNumberProvider implements RandomNumberProvider {

    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
