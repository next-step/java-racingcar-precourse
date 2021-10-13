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

	public Cars(final Car ...cars) {
		this.cars = Arrays.asList(cars);
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

	public List<Car> announceWinners(){
		Collections.sort(this.cars);
		int maxDrivenDistance = this.cars.get(0).getDrivenDistance();
		List<Car> winners = new ArrayList<>();

		for (Car car : this.cars) {
			addIfSameMaxDrivenDistance(winners, car, maxDrivenDistance);
		}

		return Collections.unmodifiableList(winners);
	}

	private void addIfSameMaxDrivenDistance(final List<Car> winners, final Car car, final int maxDrivenDistance) {
		if (car.isWinner(maxDrivenDistance)) {
			winners.add(car);
		}
	}
}


