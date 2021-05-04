package com.gotgolem.racingcar.service;

import java.util.ArrayList;
import java.util.List;

import com.gotgolem.racingcar.asset.Car;
import com.gotgolem.racingcar.asset.Cars;

public class PlayerService {

	private static final int MAX_CAR_COUNT = 10;

	public Cars toCars(String csv) {
		final String[] carNames = toCarNames(csv);
		if (carNames.length > MAX_CAR_COUNT) {
			throw new IllegalArgumentException();
		}

		final List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return new Cars(cars);
	}

	private String[] toCarNames(String csv) {
		if (csv == null) {
			return new String[0];
		}
		return omitEmpty(trim(csv.split(",")));
	}

	private String[] trim(String[] values) {
		final String[] result = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			result[i] = values[i].trim();
		}
		return result;
	}

	private String[] omitEmpty(String[] values) {
		final List<String> result = new ArrayList<>();
		for (String value : values) {
			addIfNotEmpty(result, value);
		}
		return result.toArray(new String[0]);
	}

	private void addIfNotEmpty(List<String> list, String value) {
		if (value.isEmpty()) {
			return;
		}
		list.add(value);
	}

}
