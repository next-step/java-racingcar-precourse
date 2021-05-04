package racingcar;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getMaxDistance() {
		cars.sort(Car::compareTo);
		return cars.get(0).getDistance();
	}
}
