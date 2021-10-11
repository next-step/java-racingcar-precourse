package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private final int MAX_RACING_CAR_NUMBER = 5;

	private List<RacingCar> racingCars = new ArrayList<>();

	public RacingCars(String... racingCarNames) {
		mapRacingCars(racingCarNames);
	}

	void mapRacingCars(String... racingCarNames) {
		for(String carName : racingCarNames) {
			racingCars.add(new RacingCar(carName));
		}
	}

	public Boolean validationRacingCarNumber() {
		return racingCars.size() <= MAX_RACING_CAR_NUMBER;
	}
}
