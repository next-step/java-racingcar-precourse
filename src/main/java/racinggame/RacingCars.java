package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private final List<RacingCar> racingCars = new ArrayList<>();

	public static RacingCars createCars(String[] carNames) {
		RacingCars racingCars = new RacingCars();
		for (String carName : carNames) {
			racingCars.add(RacingCar.createCar(carName));
		}
		return racingCars;
	}

	private void add(RacingCar racingCar) {
		this.racingCars.add(racingCar);
	}

}
