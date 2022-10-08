package racingcar.common.strategy;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.common.Constants.MAX_RANDOM_NUMBER;
import static racingcar.common.Constants.MIN_RANDOM_NUMBER;

public class RandomNumber implements NumberStrategy {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
