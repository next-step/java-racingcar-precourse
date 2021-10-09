package racinggame.strategy;

import nextstep.utils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MOVED_INDEX = 4;
	private static final int MOVE_NUMBER_MIN_INDEX = 0;
	private static final int MOVE_NUMBER_MAX_INDEX = 9;
	private static final String MOVE_NUMBER_EXCEPTION_MESSAGE = "입력 값은 0~9 사이여야 합니다.";

	@Override
	public boolean isMove() {
		final int number = Randoms.pickNumberInRange(MOVE_NUMBER_MIN_INDEX, MOVE_NUMBER_MAX_INDEX);
		validateNumber(number);
		return number >= MOVED_INDEX;
	}

	private void validateNumber(int number) {
		if (number < MOVE_NUMBER_MIN_INDEX || number > MOVE_NUMBER_MAX_INDEX) {
			throw new IllegalArgumentException(MOVE_NUMBER_EXCEPTION_MESSAGE);
		}
	}
}
