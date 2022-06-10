package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {

    public static final int MOVE_RANGE = 4;
    public static final int MIN_MOVE_RANGE = 1;
    public static final int MAX_MOVE_RANGE = 9;

    public boolean canMove(int randomNumber) {
        return MOVE_RANGE <= randomNumber && randomNumber <= MAX_MOVE_RANGE;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_MOVE_RANGE, MAX_MOVE_RANGE);
    }

}
