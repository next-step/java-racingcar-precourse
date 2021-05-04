package racingcar;

import java.util.ArrayList;
import java.util.List;

import sun.security.validator.ValidatorException;

public class RacingCar {
	private final List<Car> cars;

	public RacingCar(List<String> userCars) throws ValidatorException {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < userCars.size(); i++) {
			cars.add(new Car(userCars.get(i)));
		}
		this.cars = cars;
	}

	public void play() {
		for (Car car : cars) {
			car.move(RandomUtils.make());
			System.out.println(car);
		}
		System.out.println();
	}

	public String getWinners() {
		Winners winners = new Winners();
		int max;
		cars.sort(Car::compareTo);
		max = cars.get(0).getDistance();

		for (int i = 0; i < cars.size(); i++) {
			addWinner(winners, max, cars.get(i));
		}

		return winners.toString();
	}

	private void addWinner(Winners winners, int max, Car car) {
		if (max == car.getDistance()) {
			winners.add(car.getName());
		}
	}
}
