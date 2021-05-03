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

	public String currentStatus() {
		return String.format("%s\t: %s%s", name.getName(), distance.stringValue(), System.lineSeparator());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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
