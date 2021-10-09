package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racinggame.strategy.MoveStrategy;

public class Cars {

	private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "자동차는 %d대 이상이어야 합니다.";
	private static final int MIN_CAR_SIZE = 2;

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		validateCarSize(cars);
		this.cars = cars;
	}

	public static Cars of(MoveStrategy moveStrategy, String... names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(Car.of(moveStrategy, name));
		}

		return new Cars(cars);
	}

	public static Cars of(List<Car> cars) {
		return new Cars(cars);
	}

	public Cars move() {
		for (Car car : cars) {
			car.move();
		}

		return new Cars(this.cars);
	}

	public int numberOfCar() {
		return this.cars.size();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private void validateCarSize(List<Car> cars) {
		if (cars.size() < MIN_CAR_SIZE) {
			throw new IllegalArgumentException(String.format(EMPTY_NAME_EXCEPTION_MESSAGE, MIN_CAR_SIZE));
		}
	}
}
