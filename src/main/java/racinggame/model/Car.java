package racinggame.model;

public class Car {
	private CarName carName;

	public Car(String name) {
		carName = new CarName(name);
	}

	public String getName() {
		return carName.toString();
	}

	public CarPlayResult play(int value) {
		return value < 4 ? CarPlayResult.STOP : CarPlayResult.FORWARD;
	}


}
