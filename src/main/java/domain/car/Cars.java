package domain.car;

import java.util.ArrayList;
import java.util.List;

import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;
import domain.car.strategy.MovableStrategy;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	private Cars(List<Car> cars) {
		this.cars.addAll(cars);
	}

	public static Cars of(List<Car> cars) {
		return new Cars(cars);
	}

	public static Cars of(List<String> carNames, MovableStrategy movableStrategy) {
		List<Car> cars = generateCars(carNames, movableStrategy);
		return new Cars(cars);
	}

	public CarMoveResults move(){
		CarMoveResults results = new CarMoveResults();
		for (Car car : cars) {
			car.move();
			results.addCarMoveResult(CarMoveResult.of(car.getCarName(), car.getPosition()));
		}

		return results;
	}

	private static List<Car> generateCars(List<String> carNames, MovableStrategy movableStrategy) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			Car car = Car.of(carName, movableStrategy);
			cars.add(car);
		}
		return cars;
	}

}
