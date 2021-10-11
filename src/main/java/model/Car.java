package model;

import nextstep.utils.Randoms;

public class Car {
	private final String name;
	private int distance = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

	private boolean isPossibleForward() {
		int randomNumber = getRandomNumber();
		return randomNumber >= 4;
	}

	public void move() {
		if (isPossibleForward()) {
			distance += 1;
		}
	}

}
