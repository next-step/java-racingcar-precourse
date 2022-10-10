package racingcar.domain.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber4MoreMovePolicy implements MovePolicy {

    @Override
    public boolean isMove() {
        return pickRandomNumber() >= 4;
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
