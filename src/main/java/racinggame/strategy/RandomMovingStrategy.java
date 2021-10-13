package racinggame.strategy;

import nextstep.utils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
	private static final int START_RANGE = 0;
	private static final int END_RANGE = 9;
	private static final int EXECUTION_THRESHOLD = 3;

	public boolean isMoveable() {
		if(generateRandomNumber() > EXECUTION_THRESHOLD){
			return true;
		}
		return false;
	}
	private int generateRandomNumber(){
		return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
	}
}