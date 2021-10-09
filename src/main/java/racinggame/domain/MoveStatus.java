package racinggame.domain;

import nextstep.utils.Randoms;

public enum MoveStatus {
    FORWARD, STOP;

    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MIN_MOVE_FORWARD_NUMBER = 4;

    public static MoveStatus createRandom() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (randomNumber >= MIN_MOVE_FORWARD_NUMBER) {
            return FORWARD;
        }

        return STOP;
    }

    public boolean isForward() {
        return this == FORWARD;
    }
}
