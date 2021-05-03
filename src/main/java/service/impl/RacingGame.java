package service.impl;

import model.RacingCars;
import service.IRacingGame;
import view.RacingGameView;

public class RacingGame implements IRacingGame, RacingGameView {

	private final RacingCars racingCars;

	public RacingGame() {
		racingCars = new RacingCars(getRacingCarNames());
	}

	@Override
	public void play() {
		int roundNum = getRoundNum();

		System.out.println("실행 결과");
		for (int i = 0; i < roundNum; i++) {
			racingCars.nextRound();
			printRoundResult(racingCars);
		}
	}
}
