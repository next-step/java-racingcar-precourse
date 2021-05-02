package io.github.redlasha.racingcar;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;

	private Distance distance;
	private CarName name;

	public Car(CarName name) {
		this.distance = new Distance();
		this.name = name;
	}

	public void move(int condition) {
		if (condition >= MIN_MOVE_VALUE) {
			distance.add();
		}
	}

	public Distance getDistance() {
		return this.distance;
	}

	public String getCarName() {
		return name.getName();
	}

}
