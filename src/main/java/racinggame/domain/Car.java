package racinggame.domain;

public class Car {

	private static final int REQUIRED_MOVE_VALUE = 4;

	private final CarName name;

	private final Distance drivenDistance;

	public Car(final String name) {
		this.name = new CarName(name);
		this.drivenDistance = new Distance();
	}

	public CarName getCarName() {
		return this.name;
	}

	public int getDrivenDistance() {
		return drivenDistance.getDistance();
	}

	public void move(final int value) {
		if(value >= REQUIRED_MOVE_VALUE) {
			this.drivenDistance.move();
		}
	}
}
