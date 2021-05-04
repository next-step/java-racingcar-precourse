package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winners {
	private List<String> winners = new ArrayList<>();

	public void addWinner(int maxDistance, Car car) {
		if (isWinner(maxDistance, car)) {
			winners.add(car.getName());
		}
	}

	private boolean isWinner(int maxDistance, Car car) {
		return maxDistance == car.getDistance();
	}

	@Override
	public String toString() {
		return Arrays.toString(winners.toArray()).replaceAll("\\[", "").replaceAll("]", "");
	}
}
