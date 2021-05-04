package com.gotgolem.racingcar.asset;

public class Car {

	private final String name;

	public Car(String name) {
		if (isInvalid(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private boolean isInvalid(String name) {
		return name == null || name.isEmpty() || name.length() > 5;
	}

}
