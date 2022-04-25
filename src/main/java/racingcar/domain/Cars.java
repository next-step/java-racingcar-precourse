package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {
	private static final String BREAK_LINE = "\n";
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		if (!isUnique(cars)) {
			throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
		}
		this.cars = Collections.unmodifiableList(cars);
	}

	public static Cars of(String[] names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(Car.of(name));
		}
		return new Cars(cars);
	}

	private boolean isUnique(List<Car> cars) {
		return new HashSet<>(cars).size() == cars.size();
	}

	public void moveAll(MoveStrategy strategy) {
		for (Car car : cars) {
			car.move(strategy);
		}
	}

	public Winners winners() {
		return new WinnersFactory(cars).getWinners();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Car car : cars) {
			builder.append(car);
			builder.append(BREAK_LINE);
		}
		return builder.toString();
	}
}
