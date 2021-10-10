package racinggame.racingcar;

import java.util.Objects;

import racinggame.exception.InvalidCarNameException;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
