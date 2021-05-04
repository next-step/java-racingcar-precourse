package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winners {
	List<String> winners = new ArrayList<>();

	public void addWinner(int maxDistance, Car car) {
		if (maxDistance == car.getDistance()) {
			winners.add(car.getName());
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(winners.toArray()).replaceAll("\\[", "").replaceAll("]", "");
	}
}
