package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGameStrategy implements  MovementStrategy{
    public static final int MINIMUM_RANDOM_BOUNDARY = 1;
    public static final int MAXIMUM_RANDOM_BOUNDARY = 9;
    public static final int WINNING_CONDITION = 4;
    public static final boolean MOVE = true;
    public static final boolean STOP = false;

    public boolean isMovingCar() {
        if (Randoms.pickNumberInRange(MINIMUM_RANDOM_BOUNDARY, MAXIMUM_RANDOM_BOUNDARY) >= WINNING_CONDITION) {
            return MOVE;
        }
        return STOP;
    }
}
