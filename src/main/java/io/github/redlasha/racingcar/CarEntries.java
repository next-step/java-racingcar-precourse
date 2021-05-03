package io.github.redlasha.racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarEntries {

	private static final int MAX_VALUE_INDEX = 0;

	private final List<Car> carList;

	public CarEntries(String entries) {
		this.carList = new ArrayList<>();
		String[] carList = entries.split(",");
		for (String name : carList) {
			this.carList.add(new Car(name));
		}
	}

	public void moveTurn(List<Integer> conditions) {
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			car.move(conditions.get(i));
		}
	}

	public int size() {
		return carList.size();
	}

	public List<Car> getCarList() {
		return this.carList;
	}

	Distance getLongestDistance() {
		List<Car> tempList = new ArrayList<>(carList);
		tempList.sort((c1, c2) -> {
			return c2.getDistance().compareTo(c1.getDistance());
		});
		if (tempList.size() <= 0) {
			return null;
		}
		return tempList.get(MAX_VALUE_INDEX).getDistance();
	}

	public List<Car> getWinners() {
		Distance longestDistance = getLongestDistance();
		final List<Car> winners = new ArrayList<>(carList);
		winners.removeIf(car -> {
			return !longestDistance.equals(car.getDistance());
		});
		return winners;
	}

	String currentStatus() {
		StringBuilder builder = new StringBuilder();
		for (Car car : carList) {
			builder.append(car.currentStatus());
		}
		return builder.toString();
	}

}
