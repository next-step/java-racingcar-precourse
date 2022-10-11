package racingcar.common.factory;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomFactoryImpl implements RandomFactory{
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;

    @Override
    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE);
    }
}
