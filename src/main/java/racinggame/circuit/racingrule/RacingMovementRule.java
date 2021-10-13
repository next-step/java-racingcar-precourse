package racinggame.circuit.racingrule;

import racinggame.racingcar.Movement;
import racinggame.circuit.MovementRule;

public final class RacingMovementRule implements MovementRule {
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
