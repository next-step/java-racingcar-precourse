package racinggame.model;

import java.util.Objects;

import racinggame.strategy.MoveStrategy;
import racinggame.strategy.RandomMoveStrategy;

public class Car {

	private static final int START_POSITION = 0;

	private final MoveStrategy moveStrategy;
	private final CarName carName;
	private Position position;

	private Car(String name) {
		this(new RandomMoveStrategy(), name);
	}

	private Car(MoveStrategy strategy, String name) {
		this.moveStrategy = strategy;
		this.carName = CarName.valueOf(name);
		this.position = Position.valueOf(START_POSITION);
	}

	public static Car of(String name) {
		return new Car(name);
	}

	public static Car of(MoveStrategy strategy, String name) {
		return new Car(strategy, name);
	}

	public String getName() {
		return this.carName.getName();
	}

	public int getPosition() {
		return this.position.currentPosition();
	}

	public void move() {
		if (moveStrategy.isMove()) {
			this.position = this.position.move();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(moveStrategy, car.moveStrategy) && Objects.equals(carName, car.carName)
			&& Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveStrategy, carName, position);
	}
}
