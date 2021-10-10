package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public void addCar(Car car) {
		validateCar(car);
		cars.add(car);
	}

	private void validateCar(Car car) {
		if (car == null) {
			throw new NullPointerException();
		}
	}

	public int getQuantity() {
		return cars.size();
	}
}
