package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class PickRandomNumberStrategy implements PickNumberStrategy{
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    @Override
    public int pick() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
