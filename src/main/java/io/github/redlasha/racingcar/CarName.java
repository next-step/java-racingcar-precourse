package io.github.redlasha.racingcar;

public class CarName {

	private String name;

	public CarName(String name) {
		if (name == null || name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("차 이름은 5글자 이하의 문자열입니다. ");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
