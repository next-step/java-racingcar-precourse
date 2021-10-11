package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.domain.boxing.CarName;
import racinggame.domain.boxing.Position;
import racinggame.domain.strategy.MoveStrategy;
import racinggame.domain.strategy.MoveTestStayStrategy;
import racinggame.domain.strategy.Strategy;

public class Cars {

	public List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public static Cars createCars(String inputCarList) {

		List<CarName> carNames = createCarNameList(inputCarList);
		List<Car> cars = new ArrayList<>();

		for(CarName carName : carNames) {
			Car car = new Car(carName, new MoveStrategy());
			cars.add(car);
		}

		return new Cars(cars);
	}

	private static List<CarName> createCarNameList(String inputCarList) {
		List<CarName> carNameList = new ArrayList<>();
		List<String> inputNameList = Arrays.asList(inputCarList.split(","));

		for(String name : inputNameList ) {
			carNameList.add(new CarName(name));
		}

		return carNameList;
	}
}
