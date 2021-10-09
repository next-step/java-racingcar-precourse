package racinggame.model;

public class Round {

	private final Cars cars;

	public Round(Cars cars) {
		this.cars = cars;
	}

	public RoundResult play() {
		return new RoundResult(cars.move());
	}
}
