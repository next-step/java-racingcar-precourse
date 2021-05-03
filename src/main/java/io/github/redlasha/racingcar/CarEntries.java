package io.github.redlasha.racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarEntries {

	private final List<Car> carList;

	public CarEntries(String entries) {
		this.carList = new ArrayList<>();
		String[] carList = entries.split(",");
		for (String name : carList) {
			this.carList.add(new Car(name));
		}
	}

	public List<Car> getCarList() {
		return this.carList;
	}

}
