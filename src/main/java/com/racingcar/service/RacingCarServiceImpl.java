package com.racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGroup;

public class RacingCarServiceImpl implements RacingCarService {
	private static final int MAX_NAME_LENGTH = 5;
	private static final String DELM = ",";

	@Override
	public RacingCarGroup create(String input) {
		String[] names = input.split(DELM);

		checkNameArray(names);
		checkNameLength(names);

		return new RacingCarGroup(getRacingCars(names));
	}

	private void checkNameArray(String[] names) {
		Set<String> nameSet = new HashSet<>(Arrays.asList(names));

		if (nameSet.isEmpty() || names.length != nameSet.size()) {
			throw new RacingCarException(Messages.INVALID_INPUT_MESSAGE);
		}
	}

	private void checkNameLength(String[] names) {
		for (String name : names) {
			checkNameLength(name);
		}
	}

	private void checkNameLength(String name) {
		if (name.trim().length() > MAX_NAME_LENGTH || name.trim().isEmpty()) {
			throw new RacingCarException(Messages.INVALID_INPUT_MESSAGE);
		}
	}

	private List<RacingCar> getRacingCars(String[] names) {
		List<RacingCar> racingCarList = new ArrayList<>();

		for (String name : names) {
			racingCarList.add(RacingCar.create(name));
		}

		return racingCarList;
	}

}
