package racinggame.domain;

import java.util.Objects;

import racinggame.exception.UnsatisfiedMinimumValueException;

public class RaceCount {
	private static final int MIN = 0;

	private final int value;

	public RaceCount(int value) {
		checkValidCountValue(value);

		this.value = value;
	}

	public RaceCount decrease() {
		return new RaceCount(value - 1);
	}

	public boolean isRemainingCount() {
		return value < MIN;
	}

	private void checkValidCountValue(int value) {
		if (value < MIN) {
			throw new UnsatisfiedMinimumValueException(MIN);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RaceCount raceCount = (RaceCount)o;
		return value == raceCount.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "RaceCount{" +
			"value=" + value +
			'}';
	}
}
