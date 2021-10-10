package racinggame.domain;

import nextstep.utils.Randoms;

public class Movement {
    private static final int GO_MIN_VALUE = 4;
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;

    private final MovementStatus movementStatus;

    public Movement(int value) {
        movementStatus = move(value);
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public MovementStatus move(int value) {
        if (value >= GO_MIN_VALUE) {
            return MovementStatus.GO;
        }
        return MovementStatus.STOP;
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
    }
}
