package racinggame.domain;

import racinggame.domain.boxing.CarName;
import racinggame.domain.boxing.MoveStrategy;

public class Car {

	public final CarName carName;
	public int position;
	public MoveStrategy moveStrategy;

	public Car(CarName carName, MoveStrategy moveStrategy) {
		this.carName = carName;
		this.position = 0;
		this.moveStrategy = moveStrategy;
	}

	public void move() {
		if(moveStrategy.isMovable())
			position++;
	}

	public int getPosition() {
		return position;
	}
}
