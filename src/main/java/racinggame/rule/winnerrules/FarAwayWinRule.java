package racinggame.rule.winnerrules;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.LapRecords;
import racinggame.racingcar.LapRecord;
import racinggame.rule.WinnerDecisionRule;
import racinggame.rule.WinnerNames;

public class FarAwayWinRule implements WinnerDecisionRule {
	private final String EMPTY = "";

	/**
	 * 최종결과의 마지막 랩 기록으로 우승자를 결정한다.
	 * 가장 멀리 이동한 레이싱카가 우승한다.
	 * 거장 멀리 이동한 레이싱카가 2대 이상인 경우 공동 우승으로 판정한다.
	 *
	 * @param finalRecord
	 * @return {@link WinnerNames}
	 */
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
