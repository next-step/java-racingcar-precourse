package racinggame.domain.boxing;

import racinggame.error.InvalidGameRoundInput;

public class Round {

	private final int roundCount;

	public Round(String roundCount) {
		validateOnlyNumber(roundCount);
		this.roundCount = Integer.parseInt(roundCount);
	}

	private static void validateOnlyNumber(String roundCount) {

		for (int i = 0; i < roundCount.length(); i++) {
			if (!Character.isDigit(roundCount.charAt(i))) {
				throw new InvalidGameRoundInput();
			}
		}

	}

	public int getRoundCount() {
		return roundCount;
	}
}
