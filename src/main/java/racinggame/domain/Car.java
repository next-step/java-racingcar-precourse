package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int MOVE_NUMBER = 4;

	private final Name name;
	private final Position position;

	private Car(Name name) {
		this.name = name;
		this.position = Position.init();
	}

	public static Car of(Name name) {
		return new Car(name);
	}

	public Name getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public int makeRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	public void move(int randomNumber) {
		if (randomNumber >= MOVE_NUMBER) {
			position.move();
		}
	}
}
