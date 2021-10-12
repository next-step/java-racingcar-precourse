package racinggame.rule;

import racinggame.circuit.FinalRecord;
import racinggame.racingcar.Movement;
import racinggame.racinggame.Rule;

public final class RacingRule implements Rule {
	private static final int DICE_MIN = 0;
	private static final int DICE_MAX = 9;
	private static final int JUDGE_VALUE = 3;

	private final WinnerDecisionRule winnerDecisionRule;

	public RacingRule(WinnerDecisionRule winnerDecisionRule) {
		this.winnerDecisionRule = winnerDecisionRule;
	}

	@Override
	public int diceMax() {
		return this.DICE_MAX;
	}

	@Override
	public int diceMin() {
		return this.DICE_MIN;
	}

	@Override
	public Movement drive(int diceValue) {
		if (diceValue >= DICE_MIN && diceValue <= JUDGE_VALUE) {
			return Movement.STOP;
		}
		return Movement.FORWARD;
	}

	@Override
	public WinnerNames judgeWinners(FinalRecord finalRecord) {
		return winnerDecisionRule.judgeWinner(finalRecord);
	}
}
