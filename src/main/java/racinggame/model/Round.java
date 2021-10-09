package racinggame.model;

import java.util.List;

import nextstep.utils.Randoms;

public class Round {

	private final List<Car> cars;

	public Round(List<Car> cars) {
		this.cars = cars;
	}

	public RoundResult play() {
		for (Car car : cars) {
			car.move(Randoms.pickNumberInRange(0, 9));
		}
		return new RoundResult(this.cars);
	}
}
