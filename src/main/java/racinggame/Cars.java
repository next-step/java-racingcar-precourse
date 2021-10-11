package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
	private final ArrayList<Car> cars;

	public Cars(List<String> asList) {
		this.cars = new ArrayList<>();
		for (String carName : asList) {
			this.cars.add(new Car(new CarName(carName), new CarDistance(0)));
		}
	}

	public boolean isValid() {
		boolean isValid = true;
		int i = 0;
		while (isValid && i < cars.size()) {
			isValid = cars.get(i).isValid();
			++i;
		}
		return isValid;
	}

	public List<Integer> getDistances() {
		ArrayList<Integer> distances = new ArrayList<>();
		for (Car car : cars) {
			distances.add(car.getDistance());
		}
		return distances;
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}
}
