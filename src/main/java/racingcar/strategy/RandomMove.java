package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove implements Move {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_BASE_NUMBER = 4;
    private static final int MOVE_DISTANCE = 1;

    @Override
    public int move(final int currentDistance) {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

        if (randomNumber >= MOVE_BASE_NUMBER) {
            return currentDistance + MOVE_DISTANCE;
        }

        return currentDistance;
    }
}
