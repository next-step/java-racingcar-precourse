package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.utils.Message;
import racinggame.view.GameView;

public class GameController {

	private final GameView view;

	public GameController() {
		this.view = new GameView();
	}

	public void play() {
		Cars cars = makeCars();
	}

	private Cars makeCars() {
		view.print(Message.INPUT_NAME);
		String inputNames = Console.readLine();
		while (!isValidName(inputNames)) {
			inputNames = Console.readLine();
		}

		return Cars.of(inputNames);
	}

	private boolean isValidName(String inputNames) {
		try {
			Cars.of(inputNames);
		} catch (IllegalArgumentException e) {
			view.print(Message.ERROR);
			return false;
		}
		return true;
	}

}
