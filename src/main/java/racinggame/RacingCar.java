package racinggame;

import racinggame.common.CommonCode;

public class RacingCar {
	private final Name carName;
	private final Distance distance;

	private RacingCar(String carName) {
		this.carName = new Name(carName);
		this.distance = new Distance();
	}

	public static RacingCar createCar(String carName) {
		RacingCar car = new RacingCar(carName);
		return car;
	}

	public int getDistanceNumberValue() {
		return this.distance.numberValue();
	}

	public String getDistanceStringValue() {
		return this.distance.stringValue();
	}

	public String getName() {
		return this.carName.value();
	}

	public void moveForwardOrStop(int actionNumber) {
		if (isMoveForward(actionNumber)) {
			distance.increase();
		}
	}

	private boolean isMoveForward(int actionNumber) {
		if (actionNumber >= CommonCode.MOVING_FORWARD_BOUNDARY_MIN_VALUE) {
			return true;
		}
		return false;
	}
}
