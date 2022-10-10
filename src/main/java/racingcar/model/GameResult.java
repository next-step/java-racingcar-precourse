package racingcar.model;

public class GameResult {
	private final RoundsResult roundsResult;
	private final WinnerList winnerList;

	private GameResult(RoundsResult roundsResult, WinnerList winnerList) {
		this.roundsResult = roundsResult;
		this.winnerList = winnerList;
	}

	public static GameResult generate(RoundsResult roundsResult, WinnerList winnerList) {
		return new GameResult(roundsResult, winnerList);
	}

	public String getWinnerResultMessage() {
		return winnerList.getConcatNames();
	}

	public RoundsResult getRoundResult() {
		return roundsResult;
	}
}
