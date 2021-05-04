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
		int max = this.getMaxDistance();

		for (int i = 0; i < cars.size(); i++) {
			winners.addWinner(max, cars.get(i));
		}

		return winners.toString();
	}

	private int getMaxDistance() {
		cars.sort(Car::compareTo);
		return cars.get(0).getDistance();
	}
}
