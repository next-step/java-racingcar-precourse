package racinggame.model;

import racinggame.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	public static final int DEFAULT_DISTANCE = 0;
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
		ArrayList<Car> winningCars = new ArrayList<>();
		for (Car car : cars) {
			addWinningCar(winningCars, car, getMaxDistance());
		}
		return winningCars;
	}

	private void addWinningCar(ArrayList<Car> winningCars, Car car, int maxDistance) {
		if (car.getDistance() == maxDistance) {
			winningCars.add(car);
		}
	}

	private int getMaxDistance() {
		int maxDistance = DEFAULT_DISTANCE;
		for (Car car : cars) {
			maxDistance = Math.max(car.getDistance(), maxDistance);
		}
		return maxDistance;
	}
}
