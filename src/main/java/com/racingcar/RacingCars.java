package com.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private List<RacingCar> values;

	private RacingCars(List<RacingCar> values) {
		this.values = values;
	}

	public static RacingCars of(String input) {
		String[] carNames = input.split(",");
		List<RacingCar> racingCars = new ArrayList<>();

		for (String name : carNames) {
			racingCars.add(RacingCar.of(Name.of(name)));
		}

		return new RacingCars(racingCars);
	}

	public int count() {
		return this.values.size();
	}

	public List<RacingCar> getValue() {
		return this.values;
	}
}
