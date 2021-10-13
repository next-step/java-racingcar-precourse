package racinggame.domain;

import java.util.Objects;

import racinggame.strategy.MovableStrategy;
import racinggame.strategy.RandomMovableStrategy;

public class Car implements Comparable<Car> {

	private final CarName name;

	private final Distance drivenDistance;

	private final MovableStrategy movableStrategy;

	public Car(final String name) {
		this(name, new RandomMovableStrategy());
	}

	public Car(final String name, final MovableStrategy movableStrategy) {
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

	public boolean isWinner(final int maxDrivenDistance) {
		return this.getDrivenDistance() == maxDrivenDistance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(drivenDistance, car.drivenDistance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, drivenDistance);
	}

	@Override
	public int compareTo(Car target) {
		return target.getDrivenDistance() - this.getDrivenDistance();
	}

}
