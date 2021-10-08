package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.error.ValidationFailureException;
import racinggame.type.Messages;

public class SeedForMove {

    private static final int SEED_MAX_VALUE = 9;
    private static final int SEED_MIN_VALUE = 0;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final int value;

    private SeedForMove(int value) {
        if (!isSeedWithinRange(value)) {
            throw new ValidationFailureException(Messages.ERROR_SEED_NOT_IN_RANGE.getMessage());
        }
        this.value = value;
    }

    public static SeedForMove from(int value) {
        return new SeedForMove(value);
    }

    public static SeedForMove random() {
        return from(Randoms.pickNumberInRange(SEED_MIN_VALUE, SEED_MAX_VALUE));
    }

    public int getValue() {
        return value;
    }

    private boolean isSeedWithinRange(int seed) {
        return seed >= SEED_MIN_VALUE && seed <= SEED_MAX_VALUE;
    }

    public boolean shouldMoving() {
        return this.value >= MOVING_FORWARD;
    }

    public boolean shouldStop() {
        return this.value <= STOP;
    }

}
