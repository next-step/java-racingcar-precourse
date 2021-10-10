package racinggame.domain;

import java.util.Objects;

import nextstep.utils.Randoms;

public class Car {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int MOVE_NUMBER = 4;

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

	public int makeRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	public void move(int randomNumber) {
		if (randomNumber >= MOVE_NUMBER) {
			position.move();
		}
	}
}
