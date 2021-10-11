package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class CarEntry {
	public static final String SEPARATOR = " : ";
	private final ArrayList<Car> carList;

	public CarEntry(List<String> carNameList) {
		carList = new ArrayList<>();
		for (String carName : carNameList) {
			carList.add(new Car(carName));
		}
	}

	public void race() {
		for (Car car : carList) {
			car.move();
		}
	}

	public List<String> getResult() {
		ArrayList<String> result = new ArrayList<>();
		for (Car car : carList) {
			int distance = car.getDistance();
			result.add(car.getName() + SEPARATOR + createBar(distance));
		}
		return result;
	}

	private String createBar(int distance) {
		StringBuilder barBuilder = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			barBuilder.append("-");
		}
		return barBuilder.toString();
	}
}
