import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRule {

	private final int DATUM_NUMBER = 4;

	public boolean isGoForward(int gameNumber) {
		return gameNumber >= DATUM_NUMBER;
	}

	public int getWinnerLocation(List<Car> cars) {
		List<Integer> locations = new ArrayList<>();
		for (Car car : cars) {
			locations.add(car.getLocation());
		}

		return Collections.max(locations);
	}

	public List<Car> getWinners(List<Car> cars, int winnerLocation) {
		List<Car> winners = new ArrayList<>();
		cars.forEach(car -> {
			addWinners(car, winnerLocation, winners);
		});

		return winners;
	}

	private void addWinners(Car car, int winnerLocation, List<Car> winners) {
		if (isWinner(car.getLocation(), winnerLocation)) {
			winners.add(car);
		}
	}

	private boolean isWinner(int location, int winnerLocation) {
		return location == winnerLocation;
	}
}
