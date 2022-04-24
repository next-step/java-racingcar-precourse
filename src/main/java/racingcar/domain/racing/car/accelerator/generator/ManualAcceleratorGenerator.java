package racingcar.domain.racing.car.accelerator.generator;

import racingcar.domain.racing.car.accelerator.Accelerator;
import racingcar.domain.racing.car.accelerator.Power;

public class ManualAcceleratorGenerator implements AcceleratorGenerator {
    private final Power power;

    private ManualAcceleratorGenerator(int power) {
        this.power = Power.from(power);
    }

    public static ManualAcceleratorGenerator from(int power) {
        return new ManualAcceleratorGenerator(power);
    }

    @Override
    public Accelerator generate() {
        return Accelerator.from(power);
    }
}
