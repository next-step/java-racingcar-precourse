package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(final String carNames) {
		this.cars = mapToCars(parse(carNames));
	}

	private List<Car> mapToCars(final List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	private List<String> parse(final String carNames) {
		return new ArrayList<>(Arrays.asList(carNames.split(",")));
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(this.cars);
	}
}


