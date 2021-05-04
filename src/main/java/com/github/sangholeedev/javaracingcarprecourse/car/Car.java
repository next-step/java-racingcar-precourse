package com.github.sangholeedev.javaracingcarprecourse.car;

public class Car {
	private final CarName carName;
	private final RandomNumber randomNumber;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.randomNumber = new RandomNumber();
	}

	public String print() {
		return carName.getName();
	}

	public CarDrivenStatus drive() {
		randomNumber.generate();
		if (randomNumber.isGreaterThanOrEqualTo4()) {
			return CarDrivenStatus.GO;
		}
		return CarDrivenStatus.STOP;
	}

	public RandomNumber getRandomNumber() {
		return randomNumber;
	}
}
