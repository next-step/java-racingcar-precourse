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

		increaseLocation();
	}

	public void start() {
		moveForwardIfMoveable(createRandomNumber());
	}

	public Name getName() {
		return name;
	}

	public boolean isSameLocation(RacingCar other) {
		return this.location.equals(other.location);
	}

	public Location getLocation() {
		return location;
	}

	public String visualizeLocation() {
		return getLocation().visualize();
	}

	public void increaseLocation() {
		getLocation().increase();
	}

	public void printNameAndLocation() {
		System.out.println(RacingCarResult.of(this));
	}
}
