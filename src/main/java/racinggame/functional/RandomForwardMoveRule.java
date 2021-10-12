package racinggame.functional;

import nextstep.utils.Randoms;

public class RandomForwardMoveRule implements ForwardMoveRule {
	private static final int MIN_OF_FORWARD_MOVE = 4;
	private static final int MIN_OF_RANDOM_NUMBER = 0;
	private static final int MAX_OF_RANDOM_NUMBER = 9;

	@Override
	public boolean isMovable() {
		return MIN_OF_FORWARD_MOVE <= generateRandomNumber();
	}

	private int generateRandomNumber() {
		return Randoms.pickNumberInRange(MIN_OF_RANDOM_NUMBER, MAX_OF_RANDOM_NUMBER);
	}
}
