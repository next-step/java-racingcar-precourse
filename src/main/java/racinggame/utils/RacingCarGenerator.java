package racinggame.utils;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;

public class RacingCarGenerator {
	public static RacingCars generate(String[] names) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (String name : names) {
			racingCars.add(new RacingCar(name));
		}
		return new RacingCars(racingCars);
	}
}