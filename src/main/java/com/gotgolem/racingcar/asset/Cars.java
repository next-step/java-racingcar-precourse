package com.gotgolem.racingcar.asset;

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

}
