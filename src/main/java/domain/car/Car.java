package domain.car;

import domain.car.strategy.ConditionMovableStrategy;
import domain.car.strategy.MovableStrategy;
import domain.car.strategy.RandomMovableStrategy;

public class Car {

	private final CarName carName;

	private final Position position;

	private final MovableStrategy movableStrategy;

	public Car(CarName carName, Position position, MovableStrategy movableStrategy) {
		this.carName = carName;
		this.position = position;
		this.movableStrategy = movableStrategy;
	}

	public static Car of(String carName) {
		return Car.of(carName, new Position());
	}

	public static Car of(String carName, Position position) {
		return Car.of(carName, position, new RandomMovableStrategy());
	}

	public static Car of(String carName, Position position, MovableStrategy movableStrategy) {
		return new Car(CarName.of(carName), position, movableStrategy);
	}

	public Position getPosition() {
		return position;
	}

	public CarName getCarName() {
		return this.carName;
	}

	public void move() {
		if(movableStrategy.movable()){
			this.position.increment();
		}
	}
}
