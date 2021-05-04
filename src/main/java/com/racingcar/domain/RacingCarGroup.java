package com.racingcar.domain;

import java.util.List;

import com.racingcar.common.message.Messages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RacingCarGroup {
	@NonNull
	private final List<RacingCar> racingCarList;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (RacingCar car : racingCarList) {
			sb.append(car.toString());
			sb.append(Messages.NEW_LINE);
		}

		return sb.toString();
	}
}
