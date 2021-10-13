package racinggame.model;

import java.util.NoSuchElementException;

public class CarName {
	private final int MAX_LENGTH = 5;

	private final String name;

	public CarName(String name) {
		validation(name);
		this.name = name;
	}

	private void validation(String name) {
		if (name.isEmpty()) {
			throw new NoSuchElementException("명이 누락되었습니다.");
		}

		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(MAX_LENGTH + "자 이하만 가능합니다.");
		}
	}

	public String getName() {
		return this.name;
	}
}
