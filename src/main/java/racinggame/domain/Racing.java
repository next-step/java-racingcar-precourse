package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

import java.util.List;

public class Racing {

	Cars cars;
	RacingResults racingResults;
	Winners winners;

	public Racing() {
		cars = new Cars();
		winners = new Winners();
		racingResults = new RacingResults();
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

	public void join(Car car) {
		cars.addCar(car);
	}

	public void joinList(List<String> nameList) {
		for (String name : nameList) {
			join(new Car(name));
		}
	}

	public void run() {
		cars.racing();
		racingResults.addResult(cars.currentStatusString());
	}

	public void audit() {
		int maxDistance = cars.maxDistance();
		for (Car car : cars.getCarList()) {
			addWinnerList(maxDistance, car);
		}
	}

	public void addWinnerList(int max, Car car) {
		if (car.getDistance() == max) {
			winners.addWinner(car);
		}
	}

	public void startRacing(int tryCnt) {
		if (cars.size() == 0) {
			throw new IllegalStateException(ERROR_NO_CARS);
		}
		for (int i = 0; i < tryCnt; i++) {
			run();
		}
		audit();
	}

}
