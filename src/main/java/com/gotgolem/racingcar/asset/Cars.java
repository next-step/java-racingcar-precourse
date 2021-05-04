package com.gotgolem.racingcar.asset;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.cars = cars;
	}

	public Car getCar(int index) {
		return cars.get(index);
	}

	public int size() {
		return cars.size();
	}

	public Cars getTopMileageCars() {
		int max = 0;
		for (Car car : cars) {
			max = Math.max(car.getMileage(), max);
		}
		final int _max = max;
		final List<Car> _cars = new ArrayList<>(this.cars);
		_cars.removeIf(car -> car.getMileage() < _max);
		return new Cars(_cars);
	}

}
