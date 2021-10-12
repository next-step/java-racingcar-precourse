package racinggame;

import racinggame.strategy.MovingStrategy;

public class Car {
	private String name;
	private Position position;

	public Car(final String name) {
		this.name = name;
		this.position = new Position();
	}

	public int move(MovingStrategy strategy) {
		if (strategy.isMoveable()) {
			return position.move();
		}
		return position.currentPosition();
	}

	public CarDto toDto() {
		return new CarDto(name, position.currentPosition());
	}
}
