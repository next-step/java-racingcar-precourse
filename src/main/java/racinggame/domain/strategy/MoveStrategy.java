package racinggame.domain.strategy;

import nextstep.utils.Randoms;
import racinggame.common.ConstValue;

public class MoveStrategy implements Strategy{

	@Override
	public boolean isMovable() {
		int randomNumber = generateRandomNumber();

		if(randomNumber >= ConstValue.MOVE_POSSIBLE_CONDITION) {
			return true;
		}
		return false;
	}

	private int generateRandomNumber() {
		return Randoms.pickNumberInRange(ConstValue.RANDOM_MIN_NUMBER, ConstValue.RANDOM_MAX_NUMBER);
	}
}
