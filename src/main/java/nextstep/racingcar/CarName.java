package nextstep.racingcar;

import nextstep.exception.InvalidCarNameException;

public class CarName {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	private String name;

	public CarName(String name) {
		if (invalid(name)) {
			throw new InvalidCarNameException();
		}
		this.name = name;
	}

	private boolean invalid(String name) {
		return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
	}

	@Override
	public String toString() {
		return name;
	}
}
