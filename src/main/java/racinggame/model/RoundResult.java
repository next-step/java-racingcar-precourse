package racinggame.model;

import java.util.List;

public class RoundResult {

	private List<Car> cars;

	public RoundResult(List<Car> cars) {
		this.cars = cars;
	}

	public int numberOfCar() {
		return cars.size();
	}
}