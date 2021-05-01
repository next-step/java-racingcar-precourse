package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<Car>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getCarSize() {
		return cars.size();
	}

	public String getWinnersName(int moveCount) {
		String winnersName = "";
		for (Car car : cars) {
			winnersName += car.isWinner(moveCount) ? "," + car.getName() : "";
		}
		return winnersName.substring(1);
	}
}