package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class ParticipationCars {
	private final List<Car> cars;

	public ParticipationCars() {
		cars = new ArrayList<>();
	}

	public void enterRace(final Car car) {
		cars.add(car);
	}

	public void startRound() {
		for (Car car : cars) {
			car.move(car.chooseAction());
		}
	}
}
