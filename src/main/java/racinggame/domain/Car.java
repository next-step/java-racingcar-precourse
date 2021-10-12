package racinggame.domain;

import java.util.Objects;

import racinggame.functional.ForwardMoveRule;

public class Car {
	private final Name name;
	private final Position position;

	private Car(String valueOfName) {
		this(new Name(valueOfName), Position.createMinPosition());
	}

	private Car(Name name, Position position) {
		this.name = name;
		this.position = position;
	}

	public static Car createNew(String value) {
		return new Car(value);
	}

	public Car moveOrStop(ForwardMoveRule forwardMoveRule) {
		if (forwardMoveRule.isMovable()) {
			return new Car(name, position.move());
		}

		return this;
	}

	public Name getName() {
		return name;
	}

	public Position getPosition() {
		return position;
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
