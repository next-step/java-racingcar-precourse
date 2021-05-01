package com.racingcar;

public class RacingCar {
	private static final int MOVE_FORWARD_CONDITION = 4;

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

	void moveForwardIfMoveable(RandomNumber randomNumber) {
		if (randomNumber.isLessThan(MOVE_FORWARD_CONDITION)) {
			return;
		}

		this.location.increase();
	}

	public void start() {
		moveForwardIfMoveable(createRandomNumber());
	}

	public Name getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}
}
