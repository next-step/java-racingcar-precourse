package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.platform.commons.util.ToStringBuilder;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = new ArrayList<>(cars);
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> getWinners() {
		List<Car> winners = new ArrayList<>();
		int max = 0;
		for (Car car : cars) {
			max = Math.max(max, car.getPosition().getPosition());
		}
		Position winnerPosition = new Position(max);
		for (Car car : cars) {
			addWinnerTo(winners, car, winnerPosition);
		}
		return winners;
	}

	private void addWinnerTo(List<Car> winners, Car car, Position winnerPosition) {
		if (car.getPosition().equals(winnerPosition)) {
			winners.add(car);
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("cars", cars.toString())
			.toString();
	}
}
