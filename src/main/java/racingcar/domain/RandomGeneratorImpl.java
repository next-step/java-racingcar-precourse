package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGeneratorImpl implements RandomGenerator {
    @Override
    public int getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
