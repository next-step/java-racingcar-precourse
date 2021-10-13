package racinggame.rule.racing;

import racinggame.racingcar.Movement;
import racinggame.rule.racing.Rule;

public final class RacingRule implements Rule {
	private static final int DICE_MIN = 0;
	private static final int JUDGE_VALUE = 3;

	@Override
	public Movement judgeMovement(int diceValue) {
		if (diceValue >= DICE_MIN && diceValue <= JUDGE_VALUE) {
			return Movement.STOP;
		}
		return Movement.FORWARD;
	}
}
