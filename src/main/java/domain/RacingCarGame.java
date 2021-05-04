package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class RacingCarGame {
	private RacingCars racingCars;
	private RunCount runCount;

	public void gameStart() {
		gameInit();
		gameProcessing();
		gameEnding();
	}

	private void gameInit() {
		this.racingCars = InputView.racingCarNamesView();
		this.runCount = InputView.runCountView();
	}

	private void gameProcessing() {
		int count = this.runCount.get();
		for (int i = 0; i < count; i++) {
			this.racingCars.moveCars();
			OutputView.currentCarsView(i, this.racingCars);
		}
	}

	private void gameEnding() {
		List<String> winners = this.racingCars.getWinners();
		OutputView.winnerView(winners);
	}
}
