package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racinggame.utils.CollectionUtils;

public class Winner {
	private final Cars value;

	public Winner(List<Car> value) {
		this(new Cars(value));
	}

	public Winner(Cars cars) {
		Map<Position, List<Car>> roundRecord = cars.toPositionMap();
		this.value = getWinners(roundRecord);
	}

	public String getNames() {
		List<Name> names = value.getCarNames();
		List<String> result = new ArrayList<>();
		for (Name name : names) {
			result.add(name.getValue());
		}
		return CollectionUtils.joining(result);
	}

	private Cars getWinners(Map<Position, List<Car>> roundRecord) {
		Position winnerPosition = getWinnerPosition(roundRecord);
		return new Cars(roundRecord.get(winnerPosition));
	}

	private Position getWinnerPosition(Map<Position, List<Car>> cars) {
		Position positionOfWinner = Position.createMinPosition();
		for (Position position : cars.keySet()) {
			positionOfWinner = position.getMaxPosition(positionOfWinner);
		}

		return positionOfWinner;
	}
}