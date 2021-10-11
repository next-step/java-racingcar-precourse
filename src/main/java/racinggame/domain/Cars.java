package racinggame.domain;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

	private List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(String names) {
		List<Car> cars = new ArrayList<>();
		String[] arrayOfNames = names.split(",");
		for (String name : arrayOfNames) {
			cars.add(Car.of(Name.of(name)));
		}

		return new Cars(cars);
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public int getMaxPosition() {
		return Collections.max(cars, comparing(Car::getPosition)).getPosition().getValue();
	}
}
