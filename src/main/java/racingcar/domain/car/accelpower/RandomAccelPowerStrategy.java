package racingcar.domain.car.accelpower;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAccelPowerStrategy implements AccelPowerStrategy {

    private static final int THRESHOLD_ACCELERATION_POWER = 4;
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;

    @Override
    public boolean isMove() {
        return Randoms.pickNumberInRange(MIN_POWER, MAX_POWER) >= THRESHOLD_ACCELERATION_POWER;
    }
}
