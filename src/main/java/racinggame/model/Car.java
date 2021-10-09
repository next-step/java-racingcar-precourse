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

	public void roll(int times) {
		for(int i = 0; i < times; i++) {
			move(play(Randoms.pickNumberInRange(0, 9)));
		}
	}

	private void move(CarPlayResult result) {
		if (result.isForward()) {
			totalTravel.moveForward();
		}
	}

	public int getTotalTravel() {
		return totalTravel.get();
	}
}
