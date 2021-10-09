package racinggame.model;

public class Car {
	private CarName carName;

	public Car(String name) {
		carName = new CarName(name);
	}

	public String getName() {
		return carName.toString();
	}

}
