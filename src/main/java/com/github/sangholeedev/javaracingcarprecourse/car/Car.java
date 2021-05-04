package com.github.sangholeedev.javaracingcarprecourse.car;

public class Car {
	private final CarName carName;

	public Car(String carName) {
		this.carName = new CarName(carName);
	}

	public String print() {
		return carName.getName();
	}
}
