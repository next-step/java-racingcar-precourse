package racinggame.model;

import nextstep.utils.Randoms;

public class Car {
	public static final int MIN_VALUE_FORWARD = 4;
	
	private CarName carName;
	private TotalTravel totalTravel;

	public Car(String name) {
		carName = new CarName(name);
		totalTravel = new TotalTravel();
	}

	public String getName() {
		return carName.toString();
	}

	public CarPlayResult play(int value) {
		return value < MIN_VALUE_FORWARD ? CarPlayResult.STOP : CarPlayResult.FORWARD;
	}

	public void roll() {
		CarPlayResult result = play(Randoms.pickNumberInRange(0, 9));
		if (result.isForward()) {
			totalTravel.moveForward();
		}
	}

	public int getTotalTravel() {
		return totalTravel.get();
	}
}
