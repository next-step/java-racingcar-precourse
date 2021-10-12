package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racinggame.utils.CollectionUtils;

public class Winner {
	private final Cars value;

	private Winner(Cars cars) {
		Map<Position, List<Car>> carsPositionMqp = cars.toPositionMap();
		this.value = getWinners(carsPositionMqp);
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

	private Cars getWinners(Map<Position, List<Car>> carsPositionMqp) {
		Position winnerPosition = getWinnerPosition(carsPositionMqp);
		return new Cars(carsPositionMqp.get(winnerPosition));
	}

	private Position getWinnerPosition(Map<Position, List<Car>> carsPositionMqp) {
		Position positionOfWinner = Position.createMinPosition();
		for (Position position : carsPositionMqp.keySet()) {
			positionOfWinner = position.getMaxPosition(positionOfWinner);
		}

		return positionOfWinner;
	}
}