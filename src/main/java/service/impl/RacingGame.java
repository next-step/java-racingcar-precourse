package service.impl;

import static view.RacingGameView.*;

import model.RacingCars;
import service.IRacingGame;

public class RacingGame implements IRacingGame {

	private final RacingCars racingCars;

	public RacingGame() {
		racingCars = new RacingCars(getRacingCarNames());
	}

	@Override
	public void play() {
		int roundNum = getRoundNum();

		System.out.println("\n실행 결과");
		for (int i = 0; i < roundNum; i++) {
			racingCars.nextRound();
			printRoundResult(racingCars);
		}
	}

	@Override
	public void showWinners() {
		printWinners(racingCars.getMaxMileageCarNames(racingCars.getMaxMileage()));
	}
}
