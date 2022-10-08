package racingcar.domain;

import static racingcar.utils.RacingCarConstants.MIN_POWER;

public class Accelerator implements MoveStrategy {
    private final int power;

    public Accelerator(int power) {
        this.power = power;
    }

    @Override
    public boolean isMovable() {
        return this.power >= MIN_POWER;
    }
}
