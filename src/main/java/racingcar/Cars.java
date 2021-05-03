package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(String[] carNames) {
		if (carNames == null || carNames.length == 0) {
			throw new IllegalArgumentException("공백은 불가능합니다.");
		}

		List<Car> tempCarList = new ArrayList<>();
		for (String carName : carNames) {
			tempCarList.add(new Car(carName));
		}

		cars = tempCarList;
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars(){
		for (Car car : cars) {
			car.move(Utils.getRandomNumberBetween0to9());
		}
	}

	public void printCars(){
		for (Car car : cars) {
			car.printNameAndDistance();
		}
	}

	public List<Car> findWinners() {
		Collections.sort(cars);
		int distance = cars.get(0).getCarDistance();
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getCarDistance() == distance) {
				winners.add(car);
			}
		}

		return winners;
	}

}
