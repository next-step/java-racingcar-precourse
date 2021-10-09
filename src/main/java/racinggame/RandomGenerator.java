package racinggame;

import nextstep.utils.Randoms;

public class RandomGenerator implements Generator {

	protected static final int BASE_VALUE = 4;

	@Override
	public boolean canMove() {
		return Randoms.pickNumberInRange(0, 9) >= BASE_VALUE;
	}

}
