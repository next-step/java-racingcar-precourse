package com.gotgolem.racingcar.service;

import java.util.Random;

import com.gotgolem.racingcar.asset.Car;
import com.gotgolem.racingcar.asset.Cars;
import com.gotgolem.racingcar.asset.Driving;

public class CarService {

	private final Random random;

	public CarService() {
		this.random = new Random();
	}

	public void match(Cars cars) {
		final Driving[] drivings = createRandomDrivings(cars.size());
		for (int i = 0; i < cars.size(); i++) {
			final Car car = cars.getCar(i);
			car.drive(drivings[i]);
		}
	}

	private Driving[] createRandomDrivings(int size) {
		final Driving[] drivings = new Driving[size];
		for (int i = 0; i < size; i++) {
			drivings[i] = new Driving(random.nextInt(10));
		}
		return drivings;
	}

}
