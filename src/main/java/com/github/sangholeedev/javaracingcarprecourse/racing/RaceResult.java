package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.HashMap;
import java.util.Map;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;
import com.github.sangholeedev.javaracingcarprecourse.car.CarDrivenStatus;

public class RaceResult {
	private Map<Car, CarDrivenStatus> raceResults;

	public RaceResult() {
		this.raceResults = new HashMap<>();
	}

	public void result(Car car, CarDrivenStatus drive) {
		raceResults.put(car, drive);
	}

}
