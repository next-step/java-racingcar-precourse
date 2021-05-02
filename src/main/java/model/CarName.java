package model;

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
}
