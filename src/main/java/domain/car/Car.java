package domain.car;

public class Car {

	private final CarName carName;

	private final Position position;

	public Car(CarName carName, Position position) {
		this.carName = carName;
		this.position = position;
	}

	public static Car of(String carName) {
		return new Car(CarName.of(carName), new Position());
	}

	public static Car of(String carName, Position position) {
		return new Car(CarName.of(carName), position);
	}

	public Position getPosition() {
		return position;
	}

	public CarName getCarName() {
		return this.carName;
	}
}
