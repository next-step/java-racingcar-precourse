package racinggame.rule;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.LapRecords;
import racinggame.racingcar.LapRecord;

public class WinnerDecisionRule {
	private final String EMPTY = "";
	private final FinalRecord finalRecord;

	private final String delimiter = ",";

	public WinnerDecisionRule(FinalRecord finalRecord) {
		this.finalRecord = finalRecord;
	}

	public String judgeWinners() {
		WinnerNames winnerNames = new WinnerNames();
		LapRecords finalLap = finalRecord.finalLapRecords();
		int bestScore = bestScore(finalLap);

		for (LapRecord record : finalLap.getLapRecords()) {
			winnerNames.addName(getWinnerName(record, bestScore));
		}

		return winnerNames.getNamesWithDelimiter(delimiter);
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
