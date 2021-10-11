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
		int tryCount = getTryCount();
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

	private int getTryCount() {
		view.print(Message.INPUT_TRY_COUNT);
		String inputTryCount = Console.readLine();
		while (!isValidNo(inputTryCount)) {
			inputTryCount = Console.readLine();
		}

		return Integer.parseInt(inputTryCount);
	}

	private boolean isValidNo(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			view.print(Message.ERROR);
			return false;
		}
		return true;
	}

}
