package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean movable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVABLE_NUMBER;
    }
}
