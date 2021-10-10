package racinggame.strategy;

import nextstep.utils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
	private static final Integer RANDOM_MIN_NUMBER = 0;
	private static final Integer RANDOM_MAX_NUMBER = 9;
	private static final Integer MOVE_CONDITION = 4;

	@Override
	public boolean isMovable() {
		if (randomNumber() >= MOVE_CONDITION) {
			return true;
		}
		return false;
	}

	private int randomNumber() {
		return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
	}
}
