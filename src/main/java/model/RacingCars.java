package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

	public Mileage getMaxMileage() {
		Mileage mileage = new Mileage();
		for (RacingCar racingCar : value) {
			mileage = racingCar.getMileage().getValue() > mileage.getValue() ? racingCar.getMileage() : mileage;
		}
		return mileage;
	}

	public List<CarName> getMaxMileageCarNames(final Mileage maxMileage) {
		List<CarName> maxMileageCarNames = new ArrayList<>();
		for (RacingCar racingCar : value) {
			addCarName(maxMileageCarNames, racingCar.getMileage().equals(maxMileage), racingCar.getName());
		}
		return maxMileageCarNames;
	}

	private void addCarName(final List<CarName> carNames, final boolean isEnableAdd, final CarName carName) {
		if (isEnableAdd)
			carNames.add(carName);
	}

	/**
	 * 0 ~ 9 사이의 랜덤 값이 주어짐
	 * 랜덤 값이 4이상이면 이동가능
	 */
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
