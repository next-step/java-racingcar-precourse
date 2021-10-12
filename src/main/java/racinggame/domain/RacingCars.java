package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private static final String REST = ",";
	private List<Car> racingCars;

	public RacingCars() {
		this.racingCars = new ArrayList<>();
	}

	public void addCar(Car car) {
		this.racingCars.add(car);
	}

	public List<Car> getRacingCars() {
		return this.racingCars;
	}

	public String convertToString() {
		StringBuilder racingCarToString = new StringBuilder();
		for (Car car : racingCars) {
			racingCarToString.append(car.getCarName()).append(REST);
		}
		return racingCarToString.substring(0, racingCarToString.length() - 1);
	}
}
