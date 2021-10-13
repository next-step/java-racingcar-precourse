package racinggame.controller;

import static racinggame.view.ConsoleLog.*;

import java.util.List;

public class GameController {

	public void play() {
		getCarNames();
		getTryNumber();
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
