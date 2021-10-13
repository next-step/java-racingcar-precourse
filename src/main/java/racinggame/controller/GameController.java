package racinggame.controller;

import static racinggame.view.ConsoleLog.*;

import java.util.List;

import racinggame.model.RacingGame;

public class GameController {

	public void play() {
		RacingGame racingGame = new RacingGame(getCarNames());
		printResult(racingGame.start(getTryNumber()));
	}

	private List<String> getCarNames() {
		try {
			return getInputCarName();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}
	}

	private int getTryNumber() {
		try {
			return getInputTryNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getTryNumber();
		}
	}
}
