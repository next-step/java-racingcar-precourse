package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RangeFuelGenerator implements FuelGenerator {

    @Override
    public int generateFuel(int min, int max) {
        return Randoms.pickNumberInRange(min,max);
    }
}
