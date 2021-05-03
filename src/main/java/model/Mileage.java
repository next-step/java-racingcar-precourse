package model;

import java.util.Objects;

public class Mileage {
	private int value = 0;

	public int getValue() {
		return value;
	}

	public void addValue() {
		value++;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		Mileage mileage = (Mileage)o;
		return getValue() == mileage.getValue();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getValue());
	}
}
