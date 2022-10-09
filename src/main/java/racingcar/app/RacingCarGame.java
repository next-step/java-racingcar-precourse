package racingcar.app;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.view.GameView;

public class RacingCarGame {

	private final GameView gameView;

	public RacingCarGame(GameView gameView) {
		this.gameView = gameView;
	}

	public void play() {
		String names = gameView.inputCarNames();
		Cars cars = toCars(names);
		int tryNo = gameView.inputTryNo();
		gameView.printRacingResult();
		for (int i = 0; i < tryNo; i++) {
			cars.move();
			gameView.printCars(cars.getCars());
		}
		gameView.printWinners(cars.getWinners());
	}

	private Cars toCars(String carNames) {
		List<Car> cars = new ArrayList<>();
		String[] names = carNames.split(",");
		for (String name : names) {
			cars.add(new Car(new Name(name)));
		}
		return new Cars(cars);
	}
}
