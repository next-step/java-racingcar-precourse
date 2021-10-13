package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import racinggame.exception.ErrorMessage;
import racinggame.exception.InvalidInputException;
import racinggame.strategy.MovableStrategy;
import racinggame.strategy.RandomMovableStrategy;

public class Cars {

	private final List<Car> cars;

	public Cars(final List<String> carNames) {
		this(carNames, new RandomMovableStrategy());
	}

	public Cars(final List<String> carNames, final MovableStrategy movableStrategy) {
		validateLength(carNames);
		this.cars = mapToCars(carNames, movableStrategy);
	}

	private void validateLength(List<String> carNames) {
		if (carNames == null || carNames.isEmpty()){
			throw new InvalidInputException(ErrorMessage.CAR_NAME_INVALID.getMessage());
		}
	}

	private List<Car> mapToCars(final List<String> carNames, final MovableStrategy movableStrategy) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName, movableStrategy));
		}
		return cars;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(this.cars);
	}

	public void move() {
		for (Car car : this.cars) {
			car.move();
		}
	}
}


