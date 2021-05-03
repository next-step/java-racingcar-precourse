package com.racingcar.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"name"})
@Getter
public class RacingCar {

	private final String name;
	private int location;

	public static RacingCar create(String name) {
		return new RacingCar(name);
	}

	public void move(RacingCarMovingStatus status) {
		if (RacingCarMovingStatus.GO == status) {
			location++;
		}
	}

	@Override
	public String toString() {
		return name + " : " + getLocationMessage();
	}

	private String getLocationMessage() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < location; i++) {
			sb.append('_');
		}

		return sb.toString();
	}
}
