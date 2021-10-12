package racinggame.domain;

import static racinggame.common.Message.*;

import racinggame.exception.OutOfMoveCountException;

public class MoveCount {
	private static final int ZERO = 0;

	private int count;

	public MoveCount(int count) {
		if (count <= ZERO) {
			throw new OutOfMoveCountException(MOVE_COUNT_ERROR.getMessage());
		}
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}
}
