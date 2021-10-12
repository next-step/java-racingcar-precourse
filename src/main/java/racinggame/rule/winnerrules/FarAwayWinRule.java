package racinggame.rule.winnerrules;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.LapRecords;
import racinggame.racingcar.LapRecord;
import racinggame.rule.WinnerDecisionRule;
import racinggame.rule.WinnerNames;

public class FarAwayWinRule implements WinnerDecisionRule {
	private final String EMPTY = "";

	@Override
	public WinnerNames judgeWinner(FinalRecord finalRecord) {
		WinnerNames winnerNames = new WinnerNames();
		LapRecords finalLap = finalRecord.finalLapRecords();
		int bestScore = bestScore(finalLap);

		for (LapRecord record : finalLap.getLapRecords()) {
			winnerNames.addName(getWinnerName(record, bestScore));
		}

		return winnerNames;
	}

	private int bestScore(LapRecords finalLap) {
		int score = 0;

		for (LapRecord lapRecord : finalLap.getLapRecords()) {
			score = Math.max(lapRecord.getScore(), score);
		}

		return score;
	}

	private String getWinnerName(LapRecord lapRecord, int bestScore) {
		if (lapRecord.getScore() == bestScore) {
			return lapRecord.getName();
		}
		return EMPTY;
	}
}
