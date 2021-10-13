package racinggame.domain;

import racinggame.strategy.MovableStrategy;
import racinggame.strategy.RandomMovableStrategy;

public class Car {

	private static final int REQUIRED_MOVE_VALUE = 4;

	private final CarName name;

	private final Distance drivenDistance;

	private final MovableStrategy movableStrategy;

	public Car(final String name) {
		this.name = new CarName(name);
		this.drivenDistance = new Distance();
		this.movableStrategy = new RandomMovableStrategy();
	}

	public Car(final String name, MovableStrategy movableStrategy) {
		this.name = new CarName(name);
		this.drivenDistance = new Distance();
		this.movableStrategy = movableStrategy;
	}

	public CarName getCarName() {
		return this.name;
	}

	public int getDrivenDistance() {
		return drivenDistance.getDistance();
	}

	public void move() {
		if(movableStrategy.movable()){
			this.drivenDistance.move();
		}
	}
}
