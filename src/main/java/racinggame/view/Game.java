package racinggame.view;

import nextstep.utils.Console;

import static racinggame.common.Message.*;

import racinggame.controller.GameRule;
import racinggame.domain.Car;
import racinggame.domain.MoveCount;
import racinggame.domain.RacingCars;
import racinggame.exception.OutOfBoundCarNameLengthException;
import racinggame.exception.OutOfMoveCountException;

public class Game {

	private static final String REST = ",";

	private RacingCars racingCars;
	private GameRule gameRule;
	private MoveCount moveCount;

	public Game() {
		setGame();
		endGame();
	}

	private void setGame() {
		setCars();
		setMoveCount();
		gameRule = new GameRule(racingCars, moveCount);
		gameRule.gameStart();
	}

	private void endGame() {
		System.out.println(gameRule.getGameResult());
	}

	private void setCars() {
		racingCars = new RacingCars();
		String[] carNameArray = inputCarNames().split(REST);
		for (String carName : carNameArray) {
			addCar(carName);
		}
	}

	private void addCar(String carName) {
		try {
			Car car = new Car(carName);
			racingCars.addCar(car);
		} catch (OutOfBoundCarNameLengthException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void setMoveCount() {
		try {
			moveCount = new MoveCount(inputMoveCount());
		}catch (OutOfMoveCountException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private String inputCarNames() {
		System.out.println(INPUT_CAR_NAMES.getMessage());
		return Console.readLine();
	}

	private int inputMoveCount() {
		System.out.println(INPUT_MOVE_COUNT.getMessage());
		return Integer.parseInt(Console.readLine());
	}
}
