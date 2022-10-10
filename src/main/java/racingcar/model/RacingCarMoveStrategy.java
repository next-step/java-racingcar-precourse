package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarMoveStrategy implements MoveStrategy {
    public static final MoveStrategy DEFAULT = new RacingCarMoveStrategy();

    private RacingCarMoveStrategy() {
    }

    @Override
    public boolean canMove() {
        return pickNumberInRange(0, 9) >= 4;
    }
}
