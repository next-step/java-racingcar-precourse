package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnersFactory {
	private final List<Car> winners;

	public WinnersFactory(List<Car> cars) {
		winners = new ArrayList<>();
		for (Car car : cars) {
			add(car);
		}
	}

	private boolean add(Car car) {
		if (winners.isEmpty() || car.draw(winners.get(0))) {
			return winners.add(car);
		}
		if (car.win(winners.get(0))) {
			winners.clear();
			return winners.add(car);
		}
		return false;
	}

	public Winners getWinners() {
		return new Winners(winners);
	}
}
