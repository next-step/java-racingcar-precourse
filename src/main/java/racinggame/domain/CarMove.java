package racinggame.domain;

import nextstep.utils.Randoms;

public class CarMove {

	private static final int MIN_MOVE = 0;
	private static final int BASE_MOVE = 4;
	private static final int MAX_MOVE = 9;

	public CarMove() {
	}

	public boolean checkMove() {
		return Randoms.pickNumberInRange(MIN_MOVE, MAX_MOVE) >= BASE_MOVE;
	}

}
