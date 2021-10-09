package racinggame.domain;

import java.util.Objects;

import racinggame.exception.InvalidPositionValueException;

public class Position {
	private static final int MIN = 0;

	private final int value;

	public Position() {
		this(MIN);
	}

	public Position(int value) {
		checkValidValue(value);
		this.value = value;
	}

	public Position move() {
		return new Position(value + 1);
	}

	private void checkValidValue(int value) {
		if (value < MIN) {
			throw new InvalidPositionValueException(MIN);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return value == position.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Position{" +
			"value=" + value +
			'}';
	}
}
