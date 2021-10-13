package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.strategy.MovingStrategy;

public class RacingCars {
	private List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public void race(MovingStrategy strategy) {
		for (RacingCar racingCar : racingCars) {
			racingCar.move(strategy);
		}
	}

	public List<RacingCarDto> report() {
		List<RacingCarDto> dtos = new ArrayList<>();
		for (RacingCar racingCar : racingCars) {
			dtos.add(racingCar.toDto());
		}
		return dtos;
	}
}