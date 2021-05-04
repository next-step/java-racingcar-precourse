package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.ArrayList;
import java.util.List;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;

public class Winners {
	public static final String COMMA = ",";
	public static final String MESSAGE = "가 최종 우승했습니다.";
	private final List<Car> winners;

	public Winners(final RaceResults raceResults) {
		this.winners = getWinners(raceResults);
	}

	private List<Car> getWinners(RaceResults raceResults) {
		List<Car> carList = new ArrayList<>();
		int maxCount = -1;
		for (Car car : raceResults.getRaceGoMap().keySet()) {
			final Integer goCount = raceResults.getRaceGoMap().get(car);
			if (goCount > maxCount) {
				maxCount = goCount;
			}
		}

		for (Car car : raceResults.getRaceGoMap().keySet()) {
			final Integer goCount = raceResults.getRaceGoMap().get(car);
			if (goCount == maxCount) {
				carList.add(car);
			}
		}

		return carList;
	}

	public String print() {
		StringBuilder printString = new StringBuilder();
		for (Car winner : winners) {
			printString.append(winner.print()).append(COMMA);
		}
		return printString.substring(0, printString.length() - 1) + MESSAGE;
	}
}
