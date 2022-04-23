package racingcar.model;

import static racingcar.common.ErrorMessage.ENERGY_NOT_ACCEPTED;

public class CarEngine {
    private static final int MAX_ENERGY = 9;
    private static final int MIN_ENERGY = 0;
    private static final int MOVE_DISTANCE = 1;
    private static final int NO_MOVE_DISTANCE = 0;
    public static final int MINIMUM_MOVE_ENERGY = 4;

    private final int energy;

    private CarEngine(int energy) {
        this.energy = energy;
    }

    public static CarEngine charge(int energy) {
        canCharge(energy);
        return new CarEngine(energy);
    }

    private static void canCharge(int energy) {
        if(energy < MIN_ENERGY || energy > MAX_ENERGY)
            throw new IllegalArgumentException(ENERGY_NOT_ACCEPTED.text());
    }

    public int run() {
        int result = NO_MOVE_DISTANCE;
        if(canMove()) {
            result = MOVE_DISTANCE;
        }
        return result;
    }

    private boolean canMove() {
        return this.energy >= MINIMUM_MOVE_ENERGY;
    }
}
