package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Car get(int index) {
		return this.cars.get(index);
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public void move(int repeat) {
		for (int i = 0; i < repeat; i++) {
			move();
		}
	}

	public List<Car> getWinner() {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			updateWinners(winners, car);
		}
		return winners;
	}

	private void updateWinners(List<Car> winners, Car car) {
		if (winners.isEmpty()) {
			addWinner(winners, car);
			return;
		}

		Car anyWinner = winners.get(0);
		if (car.compareDistanceTo(anyWinner) == 0) {
			addWinner(winners, car);
			return;
		}
		if (car.compareDistanceTo(anyWinner) > 0) {
			initWinnersAndAddWinner(winners, car);
			return;
		}
	}

	private void initWinnersAndAddWinner(List<Car> winners, Car winner) {
		winners.clear();
		winners.add(winner);
	}

	private void addWinner(List<Car> winners, Car winner) {
		winners.add(winner);
	}
}
