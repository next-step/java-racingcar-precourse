package racinggame.model;

import nextstep.utils.Randoms;

public class Car {
	private final CarName carName;
	private final Position position;

	public Car(final String carName) {
		this.carName = new CarName(carName);
		position = new Position();
	}

	public CarAction chooseAction() {
		if (Randoms.pickNumberInRange(0, 9) > 3) {
			return CarAction.GO;
		}
		return CarAction.STOP;
	}

	public void move(final CarAction carAction) {
		if (carAction == CarAction.GO) {
			position.move();
		}
	}

	public int getPosition() {
		return position.getPosition();
	}
}
