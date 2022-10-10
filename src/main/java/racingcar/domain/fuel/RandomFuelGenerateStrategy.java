package racingcar.domain.fuel;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.contant.RacingCarConstant;

public class RandomFuelGenerateStrategy implements FuelGenerateStrategy {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RacingCarConstant.CAR_MIN_FUEL, RacingCarConstant.CAR_MAX_FUEL);
    }
}
