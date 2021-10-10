package racinggame.model;

import racinggame.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	List<Car> cars;

	public Cars(List<String> carNames, MoveStrategy moveStrategy) {
		this.cars = createCars(carNames, moveStrategy);
	}

	public List<Car> createCars(List<String> carNames, MoveStrategy moveStrategy) {
		cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name, moveStrategy));
		}
		return cars;
	}

	public void move() {
		cars.forEach(Car::move);
	}


	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinningCars() {
		return cars.stream().filter(car -> car.getDistance() == getMaxDistance()).collect(Collectors.toList());
	}


	private int getMaxDistance() {
		int maxDistance = 0;
		for (Car car : cars) {
			maxDistance = Math.max(car.getDistance(), maxDistance);
		}
		return maxDistance;
	}
}
