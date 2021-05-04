package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;
import com.github.sangholeedev.javaracingcarprecourse.car.CarDrivenStatus;

public class RaceResults {
	private final Map<Car, List<CarDrivenStatus>> raceResults;
	public static final String COLON = ":";

	public RaceResults() {
		this.raceResults = new LinkedHashMap<>();
	}

	public void report(RaceResult racing) {
		for (Car car : racing.getRaceResults().keySet()) {
			getCarDrivenStatuses(car).add(racing.getRaceResults().get(car));
			raceResults.put(car, getCarDrivenStatuses(car));
		}
	}

	private List<CarDrivenStatus> getCarDrivenStatuses(Car car) {
		List<CarDrivenStatus> carDrivenStatuses = raceResults.get(car);
		if (carDrivenStatuses == null) {
			carDrivenStatuses = new ArrayList<>();
		}
		return carDrivenStatuses;
	}

	public String print() {
		StringBuilder printString = new StringBuilder();
		for (Car car : raceResults.keySet()) {
			printString.append(car.print())
				.append(COLON)
				.append(getPrintDash(car))
				.append(System.lineSeparator());
		}
		return printString.toString();
	}

	private String getPrintDash(Car car) {
		StringBuilder printString = new StringBuilder();
		for (CarDrivenStatus carDrivenStatus : raceResults.get(car)) {
			printString.append(carDrivenStatus.print());
		}
		return printString.toString();
	}
}
