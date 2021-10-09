package nextstep.racingcar;

import java.util.List;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public Position getGreatestPosition() {
		Position greatestPosition = new Position();

		for (RacingCar racingCar : racingCars) {
			greatestPosition = racingCar.getGreaterPosition(greatestPosition);
		}

		return greatestPosition;
	}
}
