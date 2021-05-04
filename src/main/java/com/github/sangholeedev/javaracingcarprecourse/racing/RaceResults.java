package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;
import com.github.sangholeedev.javaracingcarprecourse.car.CarDrivenStatus;

public class RaceResults {
	private final Map<Car, List<CarDrivenStatus>> raceResults;
	public static final String COLON = ":";
	private final Map<Car, Integer> raceGoMap;

	public RaceResults() {
		this.raceResults = new LinkedHashMap<>();
		this.raceGoMap = new LinkedHashMap<>();
	}

	public void report(RaceResult racing) {
		for (Car car : racing.getRaceResults().keySet()) {
			final CarDrivenStatus drivenStatus = racing.getRaceResults().get(car);
			countGoMap(car, drivenStatus);
			getCarDrivenStatuses(car).add(drivenStatus);
			raceResults.put(car, getCarDrivenStatuses(car));
		}
		System.out.println(print());
	}

	private void countGoMap(Car car, CarDrivenStatus drivenStatus) {
		if (drivenStatus.isGo()) {
			raceGoMap.put(car, Optional.ofNullable(raceGoMap.get(car)).orElse(0) + 1);
		}
	}

	public Map<Car, Integer> getRaceGoMap() {
		return raceGoMap;
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

	public Winners winners() {
		return new Winners(this);
	}
}
