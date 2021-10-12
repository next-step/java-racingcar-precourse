package racinggame.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
	private static List<Car> winners = new ArrayList<>();

	private Winners(Cars cars) {
		sortCarsByDistance(cars);
		pickWinners(cars);
	}

	public static Winners init(Cars cars) {
		return new Winners(cars);
	}

	public List<Car> value() {
		return winners;
	}

	private void sortCarsByDistance(Cars cars) {
		cars.value().sort(Comparator.comparingInt((Car car) -> car.distance().value()).reversed());
	}

	private void pickWinners(Cars cars) {
		int winnerDistance = 0;

		for (Car car : cars.value()) {
			if (winnerDistance > car.distance().value()) {
				break;
			}
			winnerDistance = car.distance().value();
			winners.add(car);
		}
	}
}
