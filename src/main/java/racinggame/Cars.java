package racinggame;

import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void race(Generator generator) {

		for (Car car : cars) {
			car.move(generator);
			car.printCurrentStatus();
		}
	}
}
