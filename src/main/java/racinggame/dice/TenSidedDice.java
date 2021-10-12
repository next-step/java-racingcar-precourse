package racinggame.dice;

import nextstep.utils.Randoms;

public class TenSidedDice implements Dice {
	private static final int MIN = 0;
	private static final int MAX = 9;

	@Override
	public int roll() {
		return Randoms.pickNumberInRange(MIN, MAX);
	}
}
