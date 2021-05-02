package model;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.InvalidCarNameException;

public class RacingCars {
	private final Set<RacingCar> list;

	public RacingCars(final String... carNames) {
		list = setRacingCars(carNames);
	}

	public Set<RacingCar> getRacingCars() {
		return list;
	}

	private Set<RacingCar> setRacingCars(final String... carNames) {
		final Set<RacingCar> racingCarSet = new LinkedHashSet<>();
		for (String carName : carNames) {
			addRacingCar(racingCarSet, new CarName(carName));
		}
		return racingCarSet;
	}

	private void addRacingCar(final Set<RacingCar> racingCarSet, final CarName carName) {
		if (!racingCarSet.add(new RacingCar(carName)))
			throw new InvalidCarNameException("중복된 자동차 이름이 있습니다.");
	}
}
