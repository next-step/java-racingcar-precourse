package service.impl;

import model.RacingCars;
import service.IRacingGame;
import view.IRacingGameView;

public class RacingGame implements IRacingGame, IRacingGameView {

	private final RacingCars racingCars;

	public RacingGame() {
		racingCars = new RacingCars(getRacingCarNames());
	}

	@Override
	public void play() {

	}

}
