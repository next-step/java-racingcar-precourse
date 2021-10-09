package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars(String carNames) {
		cars = makeCarList(carNames);
	}

	private List<Car> makeCarList(String carNames) {
		cars = new ArrayList<>();
		for (String name : carNames.split(",")) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public void roll() {
		for (Car car : cars) {
			car.roll();
		}
	}

	public String getStatus() {
		StringBuffer sbStatus = new StringBuffer();
		for (Car car : cars) {
			sbStatus.append(car.getStatus());
			sbStatus.append("\n");
		}
		return sbStatus.toString();
	}
}
