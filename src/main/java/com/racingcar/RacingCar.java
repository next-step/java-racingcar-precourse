package com.racingcar;

public class RacingCar {
	private Name name;
	private Location location;

	private RacingCar(Name name, Location location) {
		this.name = name;
		this.location = location;
	}

	public static RacingCar of(Name name) {
		return new RacingCar(name, Location.init());
	}

	public RandomNumber createRandomNumber() {
		return RandomNumber.create();
	}
}
