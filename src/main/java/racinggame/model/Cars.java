package racinggame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

	private static final String REGEX = ",";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars(String name) {
		String[] carsName = toSplit(name);
		cars = toList(carsName);
	}

	private String[] toSplit(String carNames) {
		return carNames.split(REGEX);
	}

	private List<Car> toList(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
