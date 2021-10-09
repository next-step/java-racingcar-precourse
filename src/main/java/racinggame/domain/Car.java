package racinggame.domain;

import java.util.Objects;

public class Car {
	private final Name name;
	private final Position position;

	public Car(String valueOfName) {
		this(new Name(valueOfName), new Position());
	}

	public Car(Name name, Position position) {
		this.name = name;
		this.position = position;
	}

	public Car move() {
		return new Car(name, position.move());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
