package racinggame.model;

public class RoundResult {

	private final Cars cars;

	public RoundResult(Cars cars) {
		this.cars = cars;
	}

	public int numberOfCar() {
		return cars.numberOfCar();
	}
}