package racinggame.strategy;

import nextstep.utils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
	public static final int START_RANGE = 0;
	public static final int END_RANGE = 9;
	public static final int EXECUTION_BOUNDARY = 3;

	public boolean isMoveable() {
		if(generateRandomNumber() > EXECUTION_BOUNDARY){
			return true;
		}
		return false;
	}
	private int generateRandomNumber(){
		return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
	}
}
