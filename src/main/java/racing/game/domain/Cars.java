package racing.game.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public int size() {
		return cars.size();
	}

	public void add(Car car) {
		cars.add(car);
	}

	public void runLab() {
		for (Car car : cars) {
			car.movePosition();
		}
	}

	public void showLabStatus() {
		for (Car car : cars) {
			System.out.println(car.getResultGraph());
		}
	}
}
