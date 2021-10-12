package racinggame.domain;

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
		return CollectionUtils.joining(value.getCarNames());
	}

	private Cars getWinners(Cars cars) {
		Map<Position, Cars> positionCarsGroup = cars.getSamePositionCarsGroup();

		Position winnerPosition = cars.getMaxPosition();
		return positionCarsGroup.get(winnerPosition);
	}
}