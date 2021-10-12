package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racinggame.utils.CollectionUtils;

public class Winner {
	private final Cars value;

	private Winner(Cars cars) {
		this.value = getWinners(cars);
	}

	public static Winner createNew(List<Car> values) {
		return new Winner(new Cars(values));
	}

	public String getNames() {
		List<Name> names = value.getCarNames();
		List<String> result = new ArrayList<>();
		for (Name name : names) {
			result.add(name.getValue());
		}
		return CollectionUtils.joining(result);
	}

	private Cars getWinners(Cars cars) {
		Map<Position, List<Car>> carsPositionMap = cars.toPositionMap();

		Position winnerPosition = getWinnerPosition(carsPositionMap);
		return new Cars(carsPositionMap.get(winnerPosition));
	}

	private Position getWinnerPosition(Map<Position, List<Car>> carsPositionMap) {
		Position winnerPosition = Position.createMinPosition();
		for (Position position : carsPositionMap.keySet()) {
			winnerPosition = position.getMaxPosition(winnerPosition);
		}

		return winnerPosition;
	}
}