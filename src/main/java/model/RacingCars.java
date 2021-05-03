package model;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import exception.InvalidCarNameException;

public class RacingCars {
	private final Set<RacingCar> value;

	public RacingCars(final String... carNames) {
		value = setRacingCars(carNames);
	}

	public Set<RacingCar> getValue() {
		return value;
	}

	public void nextRound() {
		value.forEach(racingCar -> racingCar.move(isEnableMove()));
	}

	private boolean isEnableMove() {
		return new Random().nextInt(9) >= 4;
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
