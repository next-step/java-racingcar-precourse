package racinggame.domain;

public class Car {

	private final CarName name;

	private final Distance drivenDistance;

	public Car(String name) {
		this.name = new CarName(name);
		this.drivenDistance = new Distance();
	}

	public CarName getCarName() {
		return this.name;
	}

	public int getDrivenDistance() {
		return drivenDistance.getDistance();
	}
}
