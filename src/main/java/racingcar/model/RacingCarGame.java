package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {
	private final CarNameList carNameList;
	private final RoundCount roundCount;

	private Round currentRound;

	public RacingCarGame(CarNameList carNameList, RoundCount roundCount) {
		this.carNameList = carNameList;
		this.roundCount = roundCount;
	}

	public GameResult play() {
		RoundsResult roundsResult = playRounds();
		WinnerList winnerList = selectWinner();
		return GameResult.generate(roundsResult, winnerList);
	}

	private RoundsResult playRounds() {
		List<Round> roundList = new ArrayList<>();
		for (int i = 0; i < roundCount.getValue(); i++) {
			playRound();
			roundList.add(this.currentRound);
		}
		return RoundsResult.from(roundList);
	}

	private void playRound() {
		if (Objects.isNull(currentRound)) {
			this.currentRound = Round.start(carNameList);
		}
		this.currentRound = this.currentRound.next(carNameList);
	}

	private WinnerList selectWinner() {
		Progress maxProgress = currentRound.getMaxProgress();
		List<CarName> winnerList = new ArrayList<>();
		currentRound.getCarNameProgress().forEach(
			(carName, progress) -> addWinner(maxProgress, winnerList, carName, progress));
		return WinnerList.from(winnerList);
	}

	private void addWinner(Progress maxProgress, List<CarName> winnerList, CarName carName, Progress progress) {
		if (progress.equals(maxProgress)) {
			winnerList.add(carName);
		}
	}
}
