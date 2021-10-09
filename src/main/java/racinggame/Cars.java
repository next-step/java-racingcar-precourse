package racinggame;

import java.util.ArrayList;
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

	public List<Car> findWinners() {
		return findWinners(getFarthestPosition());
	}

	private List<Car> findWinners(Position farthestPosition) {
		List<Car> winners = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.isWinner(farthestPosition)) {
				winners.add(car);
			}
		}
		return winners;
	}

	private Position getFarthestPosition() {
		Position position = new Position();
		for (Car car : cars) {
			position = car.getFarthestPosition(position);
		}
		return position;
	}

}
