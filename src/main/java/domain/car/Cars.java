package domain.car;

import java.util.ArrayList;
import java.util.List;

import domain.car.name.CarName;
import domain.car.name.CarNames;
import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;
import domain.car.strategy.MovableStrategy;
import domain.car.strategy.RandomMovableStrategy;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	private Cars(List<Car> cars) {
		this.cars.addAll(cars);
	}

	public static Cars of(CarNames carNames) {
		return Cars.of(carNames, new RandomMovableStrategy());
	}

	public static Cars of(CarNames carNames, MovableStrategy movableStrategy) {
		List<Car> cars = generateCars(carNames, movableStrategy);
		return new Cars(cars);
	}

	public void move(){
		for (Car car : cars) {
			car.move();
		}
	}

	public CarMoveResults getCurrentMoveResults(){
		CarMoveResults results = new CarMoveResults();

		for (Car car : this.cars) {
			results.addCarMoveResult(car.getCurrentMoveResult());
		}

		return results;
	}

	private static List<Car> generateCars(CarNames carNames, MovableStrategy movableStrategy) {
		List<Car> cars = new ArrayList<>();
		for (CarName carName : carNames.getNames()) {
			Car car = Car.of(carName.toString(), movableStrategy);
			cars.add(car);
		}
		return cars;
	}

}
