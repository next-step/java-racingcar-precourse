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

	public void start(int repeatCount) {
		for (int i = 0; i < repeatCount; i++) {
			startByCar();
		}
	}

	private void startByCar() {
		for (RacingCar car : this.values) {
			car.start();
		}
	}

	public int count() {
		return this.values.size();
	}

	public List<RacingCar> getValue() {
		return this.values;
	}
}
