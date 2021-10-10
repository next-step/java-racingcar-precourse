package racinggame.domain;

public class Car {

	private final CarName name;
	private final Position position;

	private Car(CarName name) {
		this.name = name;
		this.position = Position.init();
	}

	public static Car of(CarName name) {
		return new Car(name);
	}

	public CarName getCarName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

}
