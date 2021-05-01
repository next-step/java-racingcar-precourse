package com.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private List<RacingCar> racingCars;

	private RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
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
		return this.racingCars.size();
	}

	public List<RacingCar> getValue() {
		return this.racingCars;
	}
}
