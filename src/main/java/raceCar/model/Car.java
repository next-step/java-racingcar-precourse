package raceCar.model;

import raceCar.GameValidator;

public class Car {
	private final String name;

	public Boolean canMove() {
		if (ModelUtils.getRandomNumber() >= 4) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	enum Num {
		ZERO(0),
		FOUR(4),
		NINE(9);

		private final int value;

		Num(int value) {
			this.value = value;
		}
	}

	private Car(String name) {
		this.name = name;
	}

	public static Car of(String name) {
		return new Car(name);
	}
}
