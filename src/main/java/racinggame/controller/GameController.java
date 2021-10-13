package racinggame.controller;

import static racinggame.view.ConsoleLog.*;

public class GameController {

	public void play() {
		getTryNumber();
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
