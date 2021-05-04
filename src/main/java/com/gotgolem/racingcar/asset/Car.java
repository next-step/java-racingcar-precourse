package com.gotgolem.racingcar.asset;

public class Car {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;
	private int mileage;

	public Car(String name) {
		if (isInvalid(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getMileage() {
		return mileage;
	}

	public void drive(Driving driving) {
		if (driving.isMove()) {
			mileage++;
		}
	}

	private boolean isInvalid(String name) {
		return name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH;
	}

}
