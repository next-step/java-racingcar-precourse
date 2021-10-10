package racinggame.circuit;

import java.util.List;

import racinggame.racingcar.RacingCar;

public final class RacingCars {
	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public LapRecords run() {
		LapRecords lapRecords = new LapRecords();
		racingCars.forEach(car -> {
			car.pushPedal();
			lapRecords.add(car.record());
		});

		return lapRecords;
	}

}
