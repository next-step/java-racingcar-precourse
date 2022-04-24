package racingcar.domain.racing.car.accelerator.generator;

import static racingcar.domain.constant.RacingGameConfiguration.MAXIMUM_POWER;
import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_POWER;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.racing.car.accelerator.Accelerator;

public class RandomAcceleratorGenerator implements AcceleratorGenerator {
    private RandomAcceleratorGenerator() {
    }

    public static RandomAcceleratorGenerator create() {
        return new RandomAcceleratorGenerator();
    }

    @Override
    public Accelerator generate() {
        return Accelerator.from(Randoms.pickNumberInRange(MINIMUM_POWER, MAXIMUM_POWER));
    }
}
