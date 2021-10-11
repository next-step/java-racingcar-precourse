package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private List<Car> racingCars;

	public RacingCars() {
		this.racingCars = new ArrayList<>();
	}

	public void addCar(Car car){
		this.racingCars.add(car);
	}

	public List<Car> getRacingCars(){
		return this.racingCars;
	}
}
