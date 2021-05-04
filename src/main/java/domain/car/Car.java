package domain.car;

public class Car {

	private final CarName carName;

	public Car(CarName carName) {
		this.carName = carName;
	}

	public static Car of(String carName) {
		return new Car(CarName.of(carName));
	}

	public static Car of(CarName carName) {
		return new Car(carName);
	}
}
