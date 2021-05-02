package model;

import java.util.Objects;

import exception.InvalidCarNameException;

public class CarName {
	final private String name;

	public CarName(final String name) {
		if (name == null)
			throw new InvalidCarNameException("자동차 이름이 유효하지 않습니다.");
		if (name.length() < 1 || name.length() > 5)
			throw new InvalidCarNameException("자동차 이름은 1~5자 이어야 합니다.");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		CarName carName = (CarName)o;
		return Objects.equals(getName(), carName.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}
}
