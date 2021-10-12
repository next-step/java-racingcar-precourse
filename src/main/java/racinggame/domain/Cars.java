package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars = new ArrayList<>();

	private Cars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public static Cars init(List<String> carNames) {
		return new Cars(carNames);
	}

	public List<Car> value() {
		return cars;
	}
}
