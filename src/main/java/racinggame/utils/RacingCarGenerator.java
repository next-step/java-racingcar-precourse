package racinggame.utils;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class RacingCarGenerator {
	public static Cars generate(String[] names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return new Cars(cars);
	}
}