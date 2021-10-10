package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racinggame.utils.CollectionUtils;

public class Winner {
	private final List<Car> values;

	public Winner(List<Car> cars) {
		Map<Position, List<Car>> roundRecord = getRoundRecord(cars);
		List<Car> winners = getWinners(roundRecord);
		this.values = Collections.unmodifiableList(winners);
	}

	public String getNames() {
		List<String> names = new ArrayList<>(values.size());
		for (Car winner : values) {
			Name name = winner.getName();
			names.add(name.getValue());
		}
		return CollectionUtils.joining(names);
	}

	private Map<Position, List<Car>> getRoundRecord(List<Car> cars) {
		Map<Position, List<Car>> roundRecord = new HashMap<>();
		for (Car car : cars) {
			Position position = car.getPosition();

			List<Car> sameDistanceCars = roundRecord.getOrDefault(position, new ArrayList<>());
			sameDistanceCars.add(car);
			roundRecord.put(position, sameDistanceCars);
		}
		return roundRecord;
	}

	private List<Car> getWinners(Map<Position, List<Car>> roundRecord) {
		Position winnerPosition = getWinnerPosition(roundRecord);
		return roundRecord.get(winnerPosition);
	}

	private Position getWinnerPosition(Map<Position, List<Car>> roundRecord) {
		Position positionOfWinner = new Position();
		for (Position position : roundRecord.keySet()) {
			positionOfWinner = position.getMaxPosition(positionOfWinner);
		}

		return positionOfWinner;
	}
}