package io.github.redlasha.racingcar;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;

	private Distance distance;
	private CarName name;

	public Car(String name) {
		this.distance = new Distance();
		this.name = new CarName(name);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Car other = (Car)obj;
		if (name == null || other.name == null) {
			return false;
		}
		return name.equals(other.name);
	}

}
