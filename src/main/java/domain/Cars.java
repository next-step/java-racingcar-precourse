package domain;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public Car get(int index) {
		return this.cars.get(index);
	}
}
