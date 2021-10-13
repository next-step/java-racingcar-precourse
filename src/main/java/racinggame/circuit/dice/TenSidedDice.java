package racinggame.circuit.dice;

import nextstep.utils.Randoms;
import racinggame.circuit.Dice;

public class TenSidedDice implements Dice {
	private static final int MIN = 0;
	private static final int MAX = 9;

	/**
	 * 최솟값, 최댓값 사이의 임의의 값을 반환한다.
	 * @return
	 */
	@Override
	public int roll() {
		return Randoms.pickNumberInRange(MIN, MAX);
	}
}
