package racinggame.util;

import java.util.ArrayList;
import java.util.List;

import racinggame.model.RacingCar;

public class RacingCarUtil {
	private RacingCarUtil() {
	}

	public static RacingCar createRacingCar(String name) {
		RacingCar racingCar = new RacingCar(name);
		return racingCar;
	}
	
	public static List<RacingCar> createRacingCars(String names) {
		List<RacingCar> racingCars = new ArrayList<RacingCar>();
		String[] splitedNames = names.split(",");
		for(String name : splitedNames) {
			racingCars.add(createRacingCar(name));
		}
		return racingCars;
	}
}
