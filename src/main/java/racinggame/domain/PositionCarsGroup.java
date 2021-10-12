package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionCarsGroup {
	private final Map<Position, Cars> values;

	private PositionCarsGroup(Map<Position, Cars> values) {
		this.values = values;
	}

	public static PositionCarsGroup from(Cars cars) {
		Map<Position, Cars> values = new HashMap<>();
		for (Car car : cars.getValues()) {
			Position position = car.getPosition();
			Cars sameDistanceCars = values.getOrDefault(position, new Cars(Collections.emptyList()));

			List<Car> mergedValues = new ArrayList<>(sameDistanceCars.getValues());
			mergedValues.add(car);

			values.put(position, new Cars(mergedValues));
		}
		return new PositionCarsGroup(values);
	}

	public Position getMaxPosition() {
		Position maxPosition = Position.createMinPosition();
		for (Position position : values.keySet()) {
			maxPosition = position.getMaxPosition(maxPosition);
		}

		return maxPosition;
	}

	public Cars getCars(Position position) {
		return values.get(position);
	}
}
