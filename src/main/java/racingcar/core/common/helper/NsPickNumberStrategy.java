package racingcar.core.common.helper;

import camp.nextstep.edu.missionutils.Randoms;

public class NsPickNumberStrategy implements PickNumberStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
