package racinggame.domain;

import java.util.Objects;

import racinggame.strategy.MovingStrategy;

public class Car {
	private Name name;
	private Position position;

	public Car(final String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public int move(MovingStrategy strategy) {
		if (strategy.isMoveable()) {
			return position.move();
		}
		return position.getCurrentPosition();
	}

	public CarDto toDto() {
		return new CarDto(name.getCarName(), position.getCurrentPosition());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}