package racinggame.model;

import racinggame.strategy.MoveStrategy;

public class Car {
	String name;
	int distance;
	MoveStrategy moveStrategy;

	public Car(String name, MoveStrategy moveStrategy) {
		this.name = name;
		this.distance = 0;
		this.moveStrategy = moveStrategy;
	}

	public void move() {
		if (isMovable()) {
			distance++;
		}
	}

	private boolean isMovable() {
		if (moveStrategy.isMovable()) {
			return true;
		}
		return false;
	}

	public int getDistance() {
		return distance;
	}

}
