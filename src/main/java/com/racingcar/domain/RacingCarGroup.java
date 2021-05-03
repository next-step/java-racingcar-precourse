package com.racingcar.domain;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RacingCarGroup {
	private final List<RacingCar> racingCarList;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (RacingCar car : racingCarList) {
			sb.append(car.toString());
		}

		return sb.toString();
	}
}
