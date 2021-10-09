package racinggame.model;

import java.util.Collections;

import nextstep.utils.Randoms;

public class Car {
	public static final int MIN_VALUE_FORWARD = 4;
	
	private CarName carName;
	private TotalTravel totalTravel;

	public Car(String name) {
		carName = new CarName(name);
		totalTravel = new TotalTravel();
	}

	String getName() {
		return carName.toString();
	}

	CarPlayResult play(int value) {
		return value < MIN_VALUE_FORWARD ? CarPlayResult.STOP : CarPlayResult.FORWARD;
	}

	public void roll() {
		CarPlayResult result = play(Randoms.pickNumberInRange(0, 9));
		if (result.isForward()) {
			totalTravel.moveForward();
		}
	}

	int getTotalTravel() {
		return totalTravel.get();
	}

	public String getStatus() {
		return carName + " : " + String.join("", Collections.nCopies(totalTravel.get(), "-"));
	}
}
