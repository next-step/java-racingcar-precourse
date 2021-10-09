package racinggame.model;

public class Car {

	private static final int START_POSITION = 0;

	private final CarName carName;
	private Position position;

	private Car(String name) {
		this.carName = CarName.valueOf(name);
		this.position = Position.valueOf(START_POSITION);
	}

	public static Car valueOf(String name) {
		return new Car(name);
	}

	public String getName() {
		return this.carName.getName();
	}

	public int getPosition() {
		return this.position.currentPosition();
	}

	public void move(int moveNumber) {
		this.position = this.position.move(moveNumber);
	}
}
