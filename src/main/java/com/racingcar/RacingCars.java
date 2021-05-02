package com.racingcar;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
	private List<RacingCar> values;

	RacingCars(List<RacingCar> values) {
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
			printByCar();

			printSpace();
		}
	}

	private void printSpace() {
		System.out.println("\n");
	}

	private void printByCar() {
		for (RacingCar car : this.values) {
			car.print();
		}
	}

	private void startByCar() {
		for (RacingCar car : this.values) {
			car.start();
		}
	}

	public RacingCars winners() {
		RacingCar winner = Collections.max(this.values,
			comparingInt(car -> car.getLocation().getValue()));

		List<RacingCar> result = new ArrayList<>();

		for (RacingCar car : getValues()) {
			addIfSameLocationWithWinner(winner, car, result);
		}
		return new RacingCars(result);
	}

	public List<Name> getNames() {
		List<Name> names = new ArrayList<>();

		for (RacingCar car : this.values) {
			names.add(car.getName());
		}

		return names;
	}

	private void addIfSameLocationWithWinner(RacingCar winner, RacingCar car, List<RacingCar> result) {
		if (winner.isSameLocation(car)) {
			result.add(car);
		}
	}

	public int count() {
		return this.values.size();
	}

	public List<RacingCar> getValues() {
		return Collections.unmodifiableList(this.values);
	}
}
