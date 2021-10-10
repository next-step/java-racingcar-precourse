package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {
	private final CarName carName;
	private final CarPosition carPosition;

	public Car(CarName carName) {
		this.carName = carName;
		this.carPosition = new CarPosition(0);
	}

	public String getName() {
		return this.carName.getCarName();
	}

	public int getPosition() {
		return this.carPosition.getCarPosition();
	}

	public void goForward() {
		this.carPosition.increase(Randoms.pickNumberInRange(0, 9));
	}
}
