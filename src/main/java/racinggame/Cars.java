package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final ArrayList<Car> cars;

	public Cars(List<String> names) {
		this.cars = new ArrayList<>();
		for (String carName : names) {
			this.cars.add(new Car(carName, 0));
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

	public String getWinners() {
		int farthestDistance = getFarthestDistance();
		StringBuilder winners = new StringBuilder();
		for (Car car : cars) {
			String delimeter = winners.toString().length() > 0 ? "," : "";
			boolean isFarthestDistance = car.getDistance() == farthestDistance;
			winners.append(isFarthestDistance ? delimeter : "");
			winners.append(isFarthestDistance ? car.getName() : "");
		}
		return winners.toString();
	}

	private int getFarthestDistance() {
		int max = 0;
		List<Integer> distances = getDistances();
		for (Integer distance : distances) {
			max = Math.max(max, distance);
		}
		return max;
	}
}
