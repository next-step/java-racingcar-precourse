package domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	private Cars(List<Car> cars) {
		this.cars.addAll(cars);
	}

	public static Cars of(List<Car> cars) {
		return new Cars(cars);
	}

}
