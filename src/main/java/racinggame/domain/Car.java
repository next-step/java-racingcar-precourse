package racinggame.domain;

import java.util.List;

import racinggame.common.ConstValue;
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

	public String getMoveDistanceWithName() {

		String moveDistance = "";

		for(int i=0; i<position.getPosition(); i++) {
			moveDistance+= ConstValue.OUTPUT_PROCESS_MOVE;
		}

		return carName.getCarName() + ConstValue.OUTPUT_DELIMITER + moveDistance;
	}
}
