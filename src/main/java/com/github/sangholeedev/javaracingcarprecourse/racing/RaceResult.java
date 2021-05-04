package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.LinkedHashMap;
import java.util.Map;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;
import com.github.sangholeedev.javaracingcarprecourse.car.CarDrivenStatus;

public class RaceResult {
	public static final String COLON = ":";
	private Map<Car, CarDrivenStatus> raceResults;

	public RaceResult() {
		this.raceResults = new LinkedHashMap<>();
	}

	public void result(Car car, CarDrivenStatus drive) {
		raceResults.put(car, drive);
	}

	public String print() {
		StringBuilder printString = new StringBuilder();
		for (Car car : raceResults.keySet()) {
			printString.append(car.print())
				.append(COLON)
				.append(raceResults.get(car).print())
				.append(System.lineSeparator());
		}
		return printString.toString();
	}
}
