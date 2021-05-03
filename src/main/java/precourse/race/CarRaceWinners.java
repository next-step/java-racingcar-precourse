package precourse.race;

import java.util.List;
import java.util.StringJoiner;

import precourse.car.RacingCar;

public class CarRaceWinners {

	private static final String DELIMITER = ",";
	private final List<RacingCar> racingCars;

	public CarRaceWinners(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public String getWinners() {
		StringJoiner joiner = new StringJoiner(DELIMITER);
		for (RacingCar racingCar : racingCars) {
			joiner.add(racingCar.getCarName());
		}
		return joiner.toString();
	}

}
