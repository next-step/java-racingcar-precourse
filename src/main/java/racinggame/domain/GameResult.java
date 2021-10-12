package racinggame.domain;

import static racinggame.common.Message.*;

public class GameResult {
	private RacingCars racingCars;
	private RacingCars winningCars;
	private int winNumber;

	public GameResult(RacingCars racingCars, RacingCars winningCars) {
		this.racingCars = racingCars;
		this.winningCars = winningCars;
		this.winNumber = 0;
	}

	public String getGameResult(){
		return winningCars.convertToString() + WIN_TAIL.getMessage();
	}

	public void processWiningCar() {
		for (Car car : racingCars.getRacingCars()) {
			addWinningCar(car);
		}
	}

	private void addWinningCar(Car car) {
		if (car.currentCarsToInt() < winNumber) {
			return;
		}
		if (car.currentCarsToInt() > winNumber) {
			winNumber = car.currentCarsToInt();
			winningCars.getRacingCars().clear();
			winningCars.addCar(car);
			return;
		}
		winningCars.addCar(car);
	}
}
