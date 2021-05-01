package com.racingcar;

public class RacingCarResult {
	private String value;

	private RacingCarResult(String value) {
		this.value = value;
	}

	public static RacingCarResult of(RacingCar racingCar) {
		return new RacingCarResult(
			racingCar.getName().getValue()
				+ " : "
				+ racingCar.getLocation().visualize()
		);
	}

	@Override
	public String toString() {
		return value;
	}
}
