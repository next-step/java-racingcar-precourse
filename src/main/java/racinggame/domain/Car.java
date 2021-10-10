package racinggame.domain;

import java.util.List;

import racinggame.domain.boxing.CarName;
import racinggame.domain.boxing.Position;
import racinggame.domain.strategy.Strategy;

public class Car {

	public final CarName carName;
	public Position position;
	public Strategy moveStrategy;

	public Car(CarName carName, Strategy moveStrategy) {
		this.carName = carName;
		this.moveStrategy = moveStrategy;
		position = new Position(0);
	}

	public void move() {
		if(moveStrategy.isMovable())
			position.movePosition();
	}

	public int getPosition() {
		return position.getPosition();
	}
}
