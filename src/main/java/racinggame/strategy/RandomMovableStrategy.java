package racinggame.strategy;

import nextstep.utils.Randoms;

public class RandomMovableStrategy implements MovableStrategy {

	private static final int MIN_RANDOM_VALUE = 0;

	private static final int MAX_RANDOM_VALUE = 9;

	private static final int MOVE_REQUIRED_VALUE = 4;

	@Override
	public boolean movable() {
		int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
		return randomValue >= MOVE_REQUIRED_VALUE;
	}
}
