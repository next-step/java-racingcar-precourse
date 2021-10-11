package racinggame.racingcar;

import nextstep.utils.Randoms;
import racinggame.exception.InvalidDiceException;

public final class Dice {
	private final int min;
	private final int max;

	public Dice(int min, int max) {
		validate(min, max);
		this.min = min;
		this.max = max;
	}

	private void validate(int min, int max) {
		if (min > max) {
			throw new InvalidDiceException("주사위 최솟값은 최댓값보다 작은 값으로 설정해야 합니다.");
		}
	}

	public int roll() {
		return Randoms.pickNumberInRange(min, max);
	}
}
