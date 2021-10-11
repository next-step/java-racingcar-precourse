package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.Car;
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
		makeMove(cars, tryCount);
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

	private void makeMove(Cars cars, int tryCount) {
		view.print(Message.OUTPUT_RESULT);
		for (int i = 0; i < tryCount; i++) {
			printResult(cars);
		}
	}

	private void printResult(Cars cars) {
		for (Car car : cars.getCars()) {
			car.move(Car.makeRandomNumber());
			view.print(car.getName(), car.getPosition());
		}
		System.out.println();
	}

}
