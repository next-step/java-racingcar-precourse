package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import enums.MovingStatus;

public class Racing {
    private final int RANDOM_MOVE_VALUE = 4;

    private final int RANDOM_MIN_RANGE = 0;
    private final int RANDOM_MAX_RANGE = 9;

    public MovingStatus randomValue() {
        if(pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE) >= RANDOM_MOVE_VALUE) {
            return MovingStatus.MOVING_FORWARD;
        }

        return MovingStatus.STOP;
    }
}
