package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private final static int MOVE_LIMIT_NUMBER = 4;

    @Override
    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber < MOVE_LIMIT_NUMBER) {
            return false;
        }
        return true;
    }
}
