package racinggame;

public class Car {
	private static final int MOVING_FORWARD_BOUNDARY_MIN_VALUE = 4;
	private final Name carName;
	private final Distance distance;

	private Car(String carName) {
		this.carName = new Name(carName);
		this.distance = new Distance();
	}

	public static Car createCar(String carName) {
		Car car = new Car(carName);
		return car;
	}

	public int getDistance() {
		return this.distance.value();
	}

	public String getName() {
		return this.carName.value();
	}

	public void moveForwardOrStop(int actionNumber) {
		if (isMoveForward(actionNumber)) {
			distance.increase();
		}
	}

	private boolean isMoveForward(int actionNumber) {
		if (actionNumber >= MOVING_FORWARD_BOUNDARY_MIN_VALUE) {
			return true;
		}
		return false;
	}
}
