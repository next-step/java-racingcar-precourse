package game;

import car.Car;
import car.Cars;
import io.GameInput;
import io.GameOutput;
import util.GameUtil;

public class GameMain {
	private String carName;
	private int tryCount;
	private Cars cars;

	private final GameInput gameInput = new GameInput();
	private final GameOutput gameOutput = new GameOutput();

	public void gameInit() {
		gameOutput.outputInputCarName();
		carName = gameInput.inputCarName();
		gameOutput.outputInputTryCount();
		tryCount = gameInput.inputTryCount();
		cars = new Cars(GameUtil.createCars(carName));
	}

	public void moveEachCar() {
		for (int j = 0; j < cars.getCarList().size(); j++) {
			Car car = cars.getCarList().get(j);
			int randomNum = GameUtil.generateRandomNum();
			if (GameUtil.isMovable(randomNum)) {
				car.forward();
			}
		}
	}

	public void delayGame() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void proceedGame() {
		gameInit();
		gameOutput.outputExecutionResult();
		for (int i = 0; i < tryCount; i++) {
			moveEachCar();
			gameOutput.outputExecutionResultDetail(cars.getCarList());
			delayGame();
		}
		gameOutput.outputWinner(GameUtil.getFirstPositionCarList(cars.getCarList()));
	}
}
