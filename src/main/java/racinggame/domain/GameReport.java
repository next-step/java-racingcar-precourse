package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameReport {
	private static final String COMBINE_DELIMITER = ",";
	private static final int INITIAL_THRESHOLD = 0;

	private final List<RacingCarDto> cars;

	public GameReport(final List<RacingCarDto> cars) {
		this.cars = cars;
	}

	public String reportWinnersNames() {
		int threshold = findMaxThreshold();

		return extractWinnersNames(threshold);
	}

	private String extractWinnersNames(int threshold) {
		List<String> winnerNames = new ArrayList<>();

		for (RacingCarDto car : cars) {
			winnerNames.addAll(findWinnerName(car, threshold));
		}
		return combineNames(winnerNames);
	}

	private List<String> findWinnerName(RacingCarDto car, int threshold) {
		List<String> winnerNames = new ArrayList<>();
		String name = car.getName();
		int position = car.getPosition();

		if (isWinner(position, threshold)) {
			winnerNames.add(name);
		}
		return winnerNames;
	}

	private boolean isWinner(int position, int threshold) {
		return threshold == position;
	}

	private String combineNames(List<String> names) {
		return String.join(COMBINE_DELIMITER, names);
	}

	private int findMaxThreshold() {
		int threshold = INITIAL_THRESHOLD;

		for (RacingCarDto car : cars) {
			threshold = findMaxThreshold(threshold, car.getPosition());
		}
		return threshold;
	}

	private int findMaxThreshold(int threshold, int position) {
		return Math.max(threshold, position);
	}
}