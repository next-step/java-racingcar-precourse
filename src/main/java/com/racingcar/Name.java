package com.racingcar;

public class Name {
	private static final int MAX_LENGTH = 5;

	private String value;

	private Name(String value) {
		if (value.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
		this.value = value;
	}

	public static Name of(String name) {
		return new Name(name);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
