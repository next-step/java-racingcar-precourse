package com.racingcar.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RacingCar {
	@NonNull
	@Getter
	private String name;

	@Getter
	private int location;

	public static RacingCar create(String name){
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
