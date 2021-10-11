package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

import racinggame.common.ErrorMessage;

public class Racing {

	Cars cars;
	RacingResults racingResults;
	Winners winners;

	public Racing() {
		cars = new Cars();
		winners = new Winners();
	}

	public void join(Car car) {
		cars.addCar(car);
	}

	public Cars getCars() {
		return cars;
	}

	public Winners getWinner() {
		return winners;
	}

	public RacingResults getRacingResults() {
		return racingResults;
	}

	private void checkValue(int value) {
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_GO_INPUT);
		}
	}

	public void startRacing() {
		if (cars.size() == 0) {
			throw new IllegalStateException(ERROR_NO_CARS);
		}
		cars.racing();
		racingResults.addResult(cars.getCurStatus());
	}

	public void audit() {
		for (Car car : cars.getCarList()) {
			addWinnerList(cars.maxDistance(), car);
		}
	}

	public void addWinnerList(int max, Car car) {
		if (car.getDistance() == max) {
			winners.addWinner(car);
		}
	}

}
