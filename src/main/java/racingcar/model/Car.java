package racingcar.model;

public class Car {

	private Name name;
	private Position position;

	public Car(final String name, final int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

}
