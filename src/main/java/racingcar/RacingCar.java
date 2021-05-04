package racingcar;

import java.util.ArrayList;
import java.util.List;

import sun.security.validator.ValidatorException;

public class RacingCar {
	private final Cars cars;

	public RacingCar(List<String> userCars) throws ValidatorException {
		List<Car> cars = new ArrayList<>();
		for (String carName : userCars) {
			cars.add(new Car(carName));
		}
		this.cars = new Cars(cars);
	}

	public void playAndPrintResult() {
		for (Car car : cars.getCars()) {
			car.move(RandomUtils.make());
			System.out.println(car);
		}
		System.out.println();
	}

	public String getWinners() {
		Winners winners = new Winners();
		int max = cars.getMaxDistance();

		for (Car car : cars.getCars()) {
			winners.addWinner(max, car);
		}

		return winners.toString();
	}

}
