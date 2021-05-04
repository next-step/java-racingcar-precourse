package precourse.race;

import java.util.List;

import precourse.car.RacingCar;

public class CarRaceAttemptResult {

	private final List<RacingCar> racingCars;

	public CarRaceAttemptResult(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public String createResultMessage() {
		StringBuilder builder = new StringBuilder();
		for (RacingCar racingCar : racingCars) {
			builder.append(racingCar.getCurrentStatus());
		}
		return builder.toString();
	}

}
