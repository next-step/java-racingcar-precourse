package com.github.sangholeedev.javaracingcarprecourse.player;

import java.util.ArrayList;
import java.util.List;

import com.github.sangholeedev.javaracingcarprecourse.car.CarName;

public class Player {
	private final List<CarName> carNames;
	private static final String SPLIT_WORD = ",";

	public Player(final String carNamesString) {
		this.carNames = splitCarNameString(carNamesString);
		if(carNames.isEmpty()) {
			throw new IllegalArgumentException("잘못된 이름입니다.");
		}
	}

	private List<CarName> splitCarNameString(String carNamesString) {
		List<CarName> carNamesList = new ArrayList<>();
		for (String carName : carNamesString.split(SPLIT_WORD)) {
			carNamesList.add(new CarName(carName));
		}
		return carNamesList;
	}

	public List<CarName> getCarNames() {
		return carNames;
	}
}
