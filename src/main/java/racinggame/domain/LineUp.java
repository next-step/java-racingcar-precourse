package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class LineUp {
	private final List<Car> cars = new ArrayList<>();

	public LineUp(String carNames) {
		String[] carNameArray = carNames.split(",");
		for (String carName : carNameArray) {
			addCar(carName);
		}
	}

	private void addCar(String carName) {
		this.cars.add(new Car(carName));
	}
}
