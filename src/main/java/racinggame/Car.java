package racinggame;

public class Car {
	private final CarName carName;
	private final CarDistance carDistance;

	public Car(CarName carName, CarDistance carDistance) {
		this.carName = carName;
		this.carDistance = carDistance;
	}

	public boolean isValid() {
		return carName.isValid();
	}
}
