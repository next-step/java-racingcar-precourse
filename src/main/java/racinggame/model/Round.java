package racinggame.model;

import java.util.Collections;

public class Round {

	private final Cars cars;

	public Round(Cars cars) {
		this.cars = cars;
	}

	public Round play() {
		return new Round(this.cars.move());
	}

	public Winners findWinners() {
		return this.cars.findWinners();
	}

	public Cars getCars() {
		return this.cars;
	}
}