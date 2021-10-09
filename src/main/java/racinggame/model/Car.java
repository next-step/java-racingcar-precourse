package racinggame.model;

public class Car {
	public static final int MIN_VALUE_FORWARD = 4;
	
	private CarName carName;

	public Car(String name) {
		carName = new CarName(name);
	}

	public String getName() {
		return carName.toString();
	}

	public CarPlayResult play(int value) {
		return value < MIN_VALUE_FORWARD ? CarPlayResult.STOP : CarPlayResult.FORWARD;
	}


}
