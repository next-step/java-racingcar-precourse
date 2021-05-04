package com.github.sangholeedev.javaracingcarprecourse.racing;

import java.util.ArrayList;
import java.util.List;

import com.github.sangholeedev.javaracingcarprecourse.car.Car;
import com.github.sangholeedev.javaracingcarprecourse.car.CarName;
import com.github.sangholeedev.javaracingcarprecourse.player.Player;

public class Race {
	private final List<Car> cars;
	private final RaceCount raceCount;

	public Race(final Player player, final RaceCount raceCount) {
		cars = getCars(player);
		this.raceCount = raceCount;
	}

	private List<Car> getCars(Player player) {
		final List<Car> carsList = new ArrayList<>();
		for (CarName carName : player.getCarNames()) {
			carsList.add(new Car(carName));
		}
		return carsList;
	}

	public RaceResult racing() {
		RaceResult raceResult = new RaceResult();
		for (final Car car : cars) {
			raceResult.result(car, car.drive());
		}
		return raceResult;
	}
}
