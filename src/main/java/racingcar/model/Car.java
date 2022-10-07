package racingcar.model;

public class Car {

	private Name name;
	private Position position;

	public Car(final String name, final int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void moveForward() {
		this.position.setPosition(this.position.getPosition() + 1);
	}
}
