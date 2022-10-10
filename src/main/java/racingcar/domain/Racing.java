package racingcar.domain;

import static racingcar.type.NumberRangeType.validateRange;

public class Racing {
    private static final int MOVING_FORWARD = 4;

    private boolean movingForward;

    public Racing(int random) {
        validateRange(random);
        if (random >= MOVING_FORWARD) {
            this.movingForward = true;
        }
    }

    public boolean isMovingForward() {
        return this.movingForward;
    }

}
