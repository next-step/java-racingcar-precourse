package racinggame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	List<Car> cars;

	public Cars(Car car) {
		this.cars = Collections.singletonList(car);
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createByNames(String names) {
		return new Cars(Arrays.stream(names.split(",")).map(Car::new)
															 .collect(Collectors.toList()));
	}

	public boolean isEmpty() {
		return this.cars.isEmpty();
	}
}
