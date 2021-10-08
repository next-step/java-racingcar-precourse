package racinggame.model;

import java.util.Objects;

public class Car {

	private static final int ZERO_POINT = 0;
	private final Name name;
	private final Distance distance;

	public Car(String name) {
		this.name = new Name(name);
		this.distance = new Distance(ZERO_POINT);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, distance);
	}
}
