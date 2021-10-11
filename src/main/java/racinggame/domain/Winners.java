package racinggame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Winners implements Iterable<Car> {
	private final List<Car> winners;

	private Winners(List<Car> winners) {
		this.winners = winners;
	}

	public static Winners of(Game game) {
		List<Car> winners = new ArrayList<>();
		for (Car car : game.getCars()) {
			check(winners, car);
		}
		return new Winners(winners);
	}

	private static void check(List<Car> winners, Car car) {
		if (winners.isEmpty()) {
			winners.add(car);
		}
		else if (car.getDistance().equals(winners.get(0).getDistance())) {
			winners.add(car);
		}
		else if (car.getDistance().farther(winners.get(0).getDistance())) {
			winners.clear();
			winners.add(car);
		}
	}

	@Override
	public Iterator<Car> iterator() {
		return winners.iterator();
	}
}
