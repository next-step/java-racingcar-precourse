package domain.car.result;

import domain.car.CarName;
import domain.car.Position;

public class CarMoveResult {

	private final CarName carName;

	private final Position position;

	private CarMoveResult(CarName carName, Position position) {
		this.carName = carName;
		this.position = position;
	}

	public static CarMoveResult of(CarName carName, Position position) {
		return new CarMoveResult(carName, position);
	}
}
