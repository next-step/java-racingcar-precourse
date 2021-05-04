package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.ArrayList;
import java.util.List;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;

public class RaceResults {
	private final List<RaceResult> raceResults;
	private final List<Car> winners;

	public RaceResults(List<RaceResult> raceResults) {
		this.raceResults = raceResults;
		this.winners = new ArrayList<>();
	}

}
