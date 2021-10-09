package racinggame.common;

import java.util.ArrayList;
import java.util.List;

import racinggame.racingcar.RacingCar;

public final class RacingCars {
	private final List<RacingCar> racingCars;

	public RacingCars (List<RacingCar> racingCars){
		this.racingCars = racingCars;
	}

	public List<RacingCar> getCars (){
		return new ArrayList<>(racingCars);
	}
}
