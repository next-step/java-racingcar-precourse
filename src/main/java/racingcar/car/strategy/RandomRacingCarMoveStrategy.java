package racingcar.car.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.RacingCarPosition;

public class RandomRacingCarMoveStrategy implements RacingCarMoveStrategy {
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    @Override
    public RacingCarPosition tryMove(RacingCarPosition prevPosition) {
        int random = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
        if (isMove(random)) {
            return new RacingCarPosition(prevPosition.getPosition() + 1);
        }
        return new RacingCarPosition(prevPosition.getPosition());
    }

    private boolean isMove(int random) {
        return MOVE_THRESHOLD <= random;
    }
}
