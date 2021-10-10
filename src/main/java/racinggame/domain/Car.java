package racinggame.domain;

public class Car {

	private final CarName name;

	private Car(CarName name) {
		this.name = name;
	}

	public static Car of(CarName name) {
		return new Car(name);
	}

	public CarName getCarName() {
		return name;
	}

}
