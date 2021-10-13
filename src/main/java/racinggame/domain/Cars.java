package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.common.ConstValue;
import racinggame.domain.boxing.CarName;
import racinggame.domain.strategy.MoveStrategy;

public class Cars {

	public List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createCars(String inputCarList) {

		List<CarName> carNames = createCarNameList(inputCarList);
		List<Car> cars = new ArrayList<>();

		for (CarName carName : carNames) {
			Car car = new Car(carName, new MoveStrategy());
			cars.add(car);
		}

		return new Cars(cars);
	}

	private static List<CarName> createCarNameList(String inputCarList) {
		List<CarName> carNameList = new ArrayList<>();
		List<String> inputNameList = Arrays.asList(inputCarList.split(","));

		for (String name : inputNameList) {
			carNameList.add(new CarName(name));
		}

		return carNameList;
	}

	public List<Car> getCars() {
		return cars;
	}

	public String getWinnerCars() {

		List<Car> winnerGroup = new ArrayList<>();
		String winners = "";

		for (Car car : cars) {
			if (car.getWinner()) {
				winnerGroup.add(car);
			}
		}

		for (Car car : winnerGroup) {
			winners += car.getCarName().getCarName();

			if (car != winnerGroup.get(winnerGroup.size() - 1))
				winners += ConstValue.OUTPUT_WINNER_DELIMITER;
		}

		return winners;
	}

	public void setWinner() {

		int maxPosition = getMaxPosition();

		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				car.setWinner();
			}
		}
	}

	private int getMaxPosition() {
		int maxPosition = 0;

		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}
}
