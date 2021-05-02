package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import exception.InvalidCarNameException;

public class RacingCars {
	private final Map<CarName, Mileage> list;

	public RacingCars(final CarName... carNames) {
		list = new LinkedHashMap<>();
		for (CarName carName : carNames) {
			addRacingCar(carName);
		}
	}

	public Set<CarName> getCarNames() {
		return list.keySet();
	}

	private void addRacingCar(final CarName carName) {
		if (carName == null)
			throw new InvalidCarNameException("자동차 이름이 입력되지 않았습니다.");
		final Mileage mileage = new Mileage();
		final Mileage putMileage = list.putIfAbsent(carName, mileage);
		if (putMileage == null)
			return;
		if (putMileage != mileage)
			throw new InvalidCarNameException("중복된 자동차 이름이 있습니다.");
	}
}
