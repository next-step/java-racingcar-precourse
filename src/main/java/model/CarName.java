package model;

import java.util.Objects;

import exception.InvalidCarNameException;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;

	final private String value;

	public CarName(final String name) {
		if (name == null)
			throw new InvalidCarNameException("자동차 이름이 유효하지 않습니다.");
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
			throw new InvalidCarNameException("자동차 이름은 1~5자 이어야 합니다.");
		this.value = name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		CarName carName = (CarName)o;
		return Objects.equals(getValue(), carName.getValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getValue());
	}
}
