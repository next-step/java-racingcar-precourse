package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class CarEntry {
	public static final String SEPARATOR = " : ";
	public static final int ZERO_DISTANCE = 0;
	public static final String COMMA = ",";
	public static final String BAR = "-";
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
			barBuilder.append(BAR);
		}
		return barBuilder.toString();
	}

	public String getWinner() {
		int maxDistance = getMaxDistance();
		return String.join(COMMA, getWinnersName(maxDistance));
	}

	private List<String> getWinnersName(int maxDistance) {
		ArrayList<String> winners = new ArrayList<>();
		for (Car car : carList) {
			addWinnerName(maxDistance, winners, car);
		}
		return winners;
	}

	private void addWinnerName(int maxDistance, ArrayList<String> winners, Car car) {
		if (car.getDistance() == maxDistance) {
			winners.add(car.getName());
		}
	}

	private int getMaxDistance() {
		int maxDistance = ZERO_DISTANCE;
		for (Car car : carList) {
			maxDistance = setMaxDistance(maxDistance, car);
		}
		return maxDistance;
	}

	private int setMaxDistance(int max, Car car) {
		int distance = car.getDistance();
		if (distance > max) {
			max = distance;
		}
		return max;
	}
}
