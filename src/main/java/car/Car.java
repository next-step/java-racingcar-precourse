package car;

import car.engine.CarEngine;
import constants.RacingConst;

public class Car implements Comparable<Car> {
	private final CarName carName;
	private final Distance distance;

	public Car(CarName carName, Distance distance) {
		this.carName = carName;
		this.distance = distance;
	}

	public CarName getCarName() {
		return carName;
	}

	public Distance getDistance() {
		return distance;
	}

	public String getDistanceStr() {
		return distance.getCurrentDistanceStr();
	}

	public String getCarNameStr() {
		return carName.getValue();
	}

	public void moveOneStepForward(CarEngine carEngine) {
		if (carEngine.isSuccessToRun()) {
			this.getDistance().increaseDistance(RacingConst.ONESTEP);
		}
	}

	@Override
	public int compareTo(Car o) {
		return this.distance.getValue() - o.distance.getValue();
	}
}
