package racinggame.model;

import nextstep.utils.Randoms;

public class Car {
	public static final int MIN_NUM_IN_RANDOMS = 0;
	public static final int MAX_NUM_IN_RANDOMS = 9;
	public static final int MAX_NUM_MOVE_FAIL = 3;

	private final CarName carName;
	private final CarDistance carDistance;

	public Car(String carName, int carDistance) {
		this.carName = new CarName(carName);
		this.carDistance = new CarDistance(carDistance);
	}

	public boolean isValid() {
		return carName.isValid();
	}

	public void move() {
		int pickNum = Randoms.pickNumberInRange(MIN_NUM_IN_RANDOMS, MAX_NUM_IN_RANDOMS);
		if (pickNum <= MAX_NUM_MOVE_FAIL) {
			return;
		}
		carDistance.update();
	}

	public int getDistance() {
		return carDistance.getDistance();
	}

	public String getName() {
		return carName.getName();
	}
}
